package com.alexander.bitcoindb1.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alexander.bitcoindb1.model.BitcoinPrice

@Dao
interface BitcoinPriceDAO {
    @Query("SELECT * FROM BitcoinPrice")
    fun getAll(): List<BitcoinPrice>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBitcoinPriceList(bitcoinPriceList: List<BitcoinPrice>)
}