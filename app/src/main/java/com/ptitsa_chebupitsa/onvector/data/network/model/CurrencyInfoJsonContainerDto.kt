package com.ptitsa_chebupitsa.onvector.data.network.model

import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CurrencyInfoJsonContainerDto(
    @SerializedName("Valute")
    @Expose
    val json: JsonObject?=null
)
