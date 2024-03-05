package com.ptitsa_chebupitsa.onvector.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ConvectorDao {
    @Query("SELECT*FROM currency_item ORDER BY charCode")
    fun getCurrencyList(): LiveData<List<CurrencyItemDbModel>>
    @Query("SELECT * FROM currency_item WHERE charCode == :charCode LIMIT 1")
    fun getCurrencyInfoAboutItem(charCode:String): LiveData<CurrencyItemDbModel>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrencyList(currencyList:List<CurrencyItemDbModel>)
}