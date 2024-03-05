package com.ptitsa_chebupitsa.onvector.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "currency_item")
data class CurrencyItemDbModel(
    @PrimaryKey
    var charCode: String,
    val numCode: String?,
    val nominal: Int?,
    val name: String?,
    val value: Double?,
    val previous: Double?
)
