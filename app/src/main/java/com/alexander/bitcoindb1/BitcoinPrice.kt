package com.alexander.bitcoindb1

import android.os.Parcelable
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BitcoinPrice(

    @SerializedName("x")
    var time: Long,

    @SerializedName("y")
    var price: Float

) : ValueDataEntry(time, price), Parcelable