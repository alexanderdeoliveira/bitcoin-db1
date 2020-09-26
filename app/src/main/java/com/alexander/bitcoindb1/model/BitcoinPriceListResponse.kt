package com.alexander.bitcoindb1.model

import android.os.Parcelable
import com.alexander.bitcoindb1.model.BitcoinPrice
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BitcoinPriceListResponse(
    @SerializedName("status")
    var status : String? = null,

    @SerializedName("name")
    var name : String? = null,

    @SerializedName("unit")
    var unit : String? = null,

    @SerializedName("period")
    var period : String? = null,

    @SerializedName("description")
    var description : String? = null,

    @SerializedName("values")
    var bitcoinPriceList: List<BitcoinPrice>

) : Parcelable