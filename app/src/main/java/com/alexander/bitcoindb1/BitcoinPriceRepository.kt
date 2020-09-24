package com.alexander.bitcoindb1

import io.reactivex.rxjava3.core.Observable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BitcoinPriceRepository {

    private val retrofit = Retrofit.Builder()
        .baseUrl("BaseUrl")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private var mAPI: BitcoinPriceAPI

    init {
        mAPI = retrofit.create(BitcoinPriceAPI::class.java)
    }

    fun requestBitcoinPriceList() : Observable<List<BitcoinPrice>> {
        return mAPI.requestBitcoinPriceList()
    }
}