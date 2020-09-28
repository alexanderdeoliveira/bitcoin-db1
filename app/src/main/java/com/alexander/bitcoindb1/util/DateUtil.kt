package com.alexander.bitcoindb1.util

import java.text.SimpleDateFormat
import java.util.*

class DateUtil {

    companion object {
        fun convertToTime(time: Long): String {
            val date = Date(time*1000)
            val format = SimpleDateFormat("dd/MM/yy")
            return format.format(date)
        }
    }
}