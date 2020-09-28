package com.alexander.bitcoindb1.repository

import com.alexander.bitcoindb1.model.BitcoinPriceListResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface BitcoinPriceAPI {

    @GET(BITCOIN_PRICE_LIST)
    fun requestBitcoinPriceList(@Query("timespan") timespan:String?): Observable<BitcoinPriceListResponse>

    companion object {
        const val BITCOIN_PRICE_LIST = "/charts/market-price"
    }
}