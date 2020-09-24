package com.alexander.bitcoindb1

import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface BitcoinPriceAPI {

    @GET(BITCOIN_PRICE_LIST)
    fun requestBitcoinPriceList(): Observable<BitcoinPriceListResponse>

    companion object {
        const val BITCOIN_PRICE_LIST = "/charts/transactions-per-second"
    }
}