package com.alexander.bitcoindb1

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class BitcoinPrice(

    @SerializedName("x")
    @PrimaryKey
    var time: Long,

    @SerializedName("y")
    var price: Float

) : Parcelable