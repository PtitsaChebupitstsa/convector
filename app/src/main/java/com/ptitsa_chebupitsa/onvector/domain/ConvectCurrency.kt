package com.ptitsa_chebupitsa.onvector.domain

data class ConvectCurrency(
    val charCode:String,
    var numCode:String?,
    val nominal:Int?,
    val name:String?,
    val value:Double?,
    val previous:Double?,
    val convectValue:Double ?= DEF_VALUE,
){
    companion object{
        const val DEF_VALUE = 0.0
    }


}
