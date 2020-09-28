package com.alexander.bitcoindb1.util

import java.text.SimpleDateFormat
import java.util.*

class DateUtil {

    companion object {
        fun convertLongToTime(time: Long): String {
            val date = Date(time)
            val format = SimpleDateFormat("dd/MM")
            return format.format(date)
        }
    }
}