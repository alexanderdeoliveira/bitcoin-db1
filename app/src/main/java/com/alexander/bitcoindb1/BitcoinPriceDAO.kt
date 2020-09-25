package com.alexander.bitcoindb1

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface BitcoinPriceDAO {
    @Query("SELECT * FROM BitcoinPrice")
    fun getAll(): List<BitcoinPrice>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBitcoinPriceList(bitcoinPriceList: List<BitcoinPrice>)
}