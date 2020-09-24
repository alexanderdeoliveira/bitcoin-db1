package com.alexander.bitcoindb1

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface BitcoinPriceDAO {
    @Query("SELECT * FROM BitcoinPrice")
    fun getAll(): List<BitcoinPrice>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBitcoinPriceList(bitcoinPriceList: List<BitcoinPrice>)
}