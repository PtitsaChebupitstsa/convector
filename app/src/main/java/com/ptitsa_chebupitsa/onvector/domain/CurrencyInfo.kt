package com.ptitsa_chebupitsa.onvector.domain

data class CurrencyInfo (
    val charCode:String,
    var numCode:String?,
    val nominal:Int?,
    val name:String?,
    val value:Double?,
    val previous:Double?
)