package com.alexander.bitcoindb1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), MainContract.View {

    var presenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)
    }

    override fun showLastBitcoinPrice() {
        TODO("Not yet implemented")
    }

    override fun showBitcoinPriceChart() {
        TODO("Not yet implemented")
    }

    override fun setBitcoinPriceList(bitcoinPriceList: List<BitcoinPrice>) {
        TODO("Not yet implemented")
    }
}