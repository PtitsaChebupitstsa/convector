package com.ptitsa_chebupitsa.onvector.data.mapper

import com.ptitsa_chebupitsa.onvector.data.db.CurrencyItemDbModel
import com.ptitsa_chebupitsa.onvector.data.network.model.CurrencyContainerDto
import com.ptitsa_chebupitsa.onvector.data.network.model.CurrencyNameContainerDto
import com.ptitsa_chebupitsa.onvector.domain.ConvectCurrency
import com.ptitsa_chebupitsa.onvector.domain.CurrencyInfo
import javax.inject.Inject

class ConvectorMapper @Inject constructor() {
    fun mapDbModelCurrencyListToEntityList(dbModelList: List<CurrencyItemDbModel>):List<CurrencyInfo>{
        return dbModelList.map {  mapDbCurrencyModelToEntity(it) }
    }
    fun mapCurrencyListToConvectCurrencyList(currencyList: List<CurrencyInfo>,value: Double):List<ConvectCurrency>{
        return currencyList.map {mapCurrencyListToConvectCurrency(it,value) }
    }

    fun mapCurrencyListToConvectCurrency(currencyList: CurrencyInfo, value: Double) = ConvectCurrency(
        charCode = currencyList.charCode,
        numCode = currencyList.numCode,
        nominal = currencyList.nominal,
        name = currencyList.name,
        value = currencyList.value,
        previous = currencyList.previous,
        convectValue = value  / ((currencyList.previous?:1.0 )/ (currencyList.nominal ?: 1))
        //todo заменить магаческие цифры 1.0 и 1 на компаьен обджект
    )

    fun mapDbCurrencyModelToEntity(dbModel: CurrencyItemDbModel) = CurrencyInfo(
        charCode = dbModel.charCode,
        numCode =  dbModel.numCode,
        nominal = dbModel.nominal,
        name = dbModel.name,
        value = dbModel.value,
        previous = dbModel.previous,

    )


    fun mapEntityCurrencyToDbModel(dto: CurrencyContainerDto) = CurrencyItemDbModel(
        charCode = dto.charCode,
        numCode = dto.numCode,
        nominal = dto.nominal,
        name = dto.name,
        value = dto.value.toDouble(),
        previous = dto.previous.toDouble()
    )

    fun mapNamesListToString(namesListDto : CurrencyNameContainerDto) :String{
        return namesListDto.currency.map {
            it.key
        }.toString()
    }
    fun mapCurrencyContainerToListCurrencyInfoList(currencyNameContainerDto: CurrencyNameContainerDto):List<CurrencyItemDbModel>{
        val result= mutableListOf<CurrencyItemDbModel>()
        val currencyObject = currencyNameContainerDto.currency
        val currencyKeySet = currencyObject.keys
        for (currencyKey in currencyKeySet){
            val currencyItemObject = currencyObject[currencyKey]
            currencyItemObject?.let { mapEntityCurrencyToDbModel(it) }?.let { result.add(it) }
        }
        return result
    }
}