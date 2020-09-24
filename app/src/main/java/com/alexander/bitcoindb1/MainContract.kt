package com.alexander.bitcoindb1

import com.anychart.charts.Cartesian

interface MainContract {
    interface View {
        fun bindingView()
        fun showLastBitcoinPrice()
        fun showBitcoinPriceChart()
        fun setLastBitcoinPrice(bitcoinPrice: BitcoinPrice)
        fun setBitcoinPriceChart(cartesian: Cartesian)
    }

    interface Presenter {
        fun init()
        fun insertBitcoinPriceList(bitcoinPriceList: List<BitcoinPrice>)
        fun getBitcoinPriceList()
    }
}