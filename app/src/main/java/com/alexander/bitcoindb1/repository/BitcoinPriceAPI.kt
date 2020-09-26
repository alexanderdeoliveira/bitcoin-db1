package com.alexander.bitcoindb1.repository

import com.alexander.bitcoindb1.model.BitcoinPriceListResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface BitcoinPriceAPI {

    @GET(BITCOIN_PRICE_LIST)
    fun requestBitcoinPriceList(): Observable<BitcoinPriceListResponse>

    companion object {
        const val BITCOIN_PRICE_LIST = "/charts/transactions-per-second"
    }
}