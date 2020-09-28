package com.alexander.bitcoindb1.repository

import com.alexander.bitcoindb1.model.BitcoinPrice
import com.alexander.bitcoindb1.model.BitcoinPriceListResponse
import com.alexander.bitcoindb1.database.BitcoinPriceDAO
import io.reactivex.rxjava3.core.Observable
import retrofit2.Retrofit

class BitcoinPriceRepository(
    private val bitcoinPriceDAO: BitcoinPriceDAO,
    private val retrofit: Retrofit
) {

    private var mAPI: BitcoinPriceAPI = retrofit.create(BitcoinPriceAPI::class.java)

    fun requestBitcoinPriceList(timespan:String?) : Observable<BitcoinPriceListResponse> {
        return mAPI.requestBitcoinPriceList(timespan)
    }

    fun insertBitcoinPriceList(bitcoinPriceList: List<BitcoinPrice>) {
        return bitcoinPriceDAO.insertBitcoinPriceList(bitcoinPriceList)
    }
}