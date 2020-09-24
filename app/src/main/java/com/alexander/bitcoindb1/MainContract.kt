package com.alexander.bitcoindb1

interface MainContract {
    interface View {
        fun showLastBitcoinPrice()
        fun showBitcoinPriceChart()
        fun setBitcoinPriceList(bitcoinPriceList:List<BitcoinPrice>)
    }

    interface Presenter {
        fun getBitcoinPriceList()
    }
}