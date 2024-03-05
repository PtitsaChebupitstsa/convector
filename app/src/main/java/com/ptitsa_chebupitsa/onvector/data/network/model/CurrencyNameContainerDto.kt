package com.ptitsa_chebupitsa.onvector.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CurrencyNameContainerDto(
    @SerializedName("Date")
    @Expose
    val data:String?,
    @SerializedName("Valute")
    @Expose
    val currency:Map<String,CurrencyContainerDto>
)
