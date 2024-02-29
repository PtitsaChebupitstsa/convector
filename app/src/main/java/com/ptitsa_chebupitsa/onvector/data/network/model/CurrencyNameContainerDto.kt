package com.ptitsa_chebupitsa.onvector.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CurrencyNameContainerDto(
    @SerializedName("Valute")
    @Expose
    var currency:List<CurrencyNameDto>?=null

)
