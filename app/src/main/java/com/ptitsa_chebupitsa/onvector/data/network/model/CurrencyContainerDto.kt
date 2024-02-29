package com.ptitsa_chebupitsa.onvector.data.network.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
@Entity(tableName = "full_currency_info")
class CurrencyContainerDto(
    @SerializedName("ID")
    @Expose
    var iD: String?,
    @SerializedName("NumCode")
    @Expose
    var numCode: String?,
    @PrimaryKey
    @SerializedName("CharCode")
    @Expose
    var charCode: String,
    @SerializedName("Nominal")
    @Expose
    var nominal: Int?,
    @SerializedName("Name")
    @Expose
    var name: String?,
    @SerializedName("Value")
    @Expose
    var value: Double?,
    @SerializedName("Previous")
    @Expose
    var previous: Double?


)