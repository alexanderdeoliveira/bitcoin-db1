package com.alexander.bitcoindb1.util

import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

class MonetaryUtil {

    companion object {
        fun convertToMonetary(text: Float): String {
            val format = NumberFormat.getCurrencyInstance()
            format.maximumFractionDigits = 0;
            format.currency = Currency.getInstance("USD")

            return format.format(text)
        }
    }
}