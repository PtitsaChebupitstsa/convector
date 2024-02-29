package com.ptitsa_chebupitsa.onvector.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CurrencyNameDto(
    @SerializedName("CharCode")
    @Expose
    val name:String?=null
)
