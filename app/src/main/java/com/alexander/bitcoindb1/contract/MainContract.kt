package com.alexander.bitcoindb1.contract

import com.alexander.bitcoindb1.model.BitcoinPrice
import com.anychart.charts.Cartesian

interface MainContract {
    interface View {
        fun bindingView()
        fun showLastBitcoinPrice()
        fun showBitcoinPriceChart()
        fun showSnackbarError()
        fun setLastBitcoinPrice(bitcoinPrice: BitcoinPrice)
        fun setBitcoinChart(cartesian: Cartesian)
        fun setSpinner()
    }

    interface Presenter {
        fun init()
        fun getBitcoinPriceList(timespan: String?)
        fun onTimespanSelected(timespan: String?)
    }
}