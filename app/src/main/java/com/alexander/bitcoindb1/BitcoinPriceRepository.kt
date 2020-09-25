package com.alexander.bitcoindb1

import androidx.lifecycle.LiveData
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class BitcoinPriceRepository(
    private val bitcoinPriceDAO: BitcoinPriceDAO
) {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.blockchain.info")
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private var mAPI: BitcoinPriceAPI

    init {
        mAPI = retrofit.create(BitcoinPriceAPI::class.java)
    }

    fun requestBitcoinPriceList() : Observable<BitcoinPriceListResponse> {
        return mAPI.requestBitcoinPriceList()
    }

    fun insertBitcoinPriceList(bitcoinPriceList: List<BitcoinPrice>) {
        return bitcoinPriceDAO.insertBitcoinPriceList(bitcoinPriceList)
    }
}