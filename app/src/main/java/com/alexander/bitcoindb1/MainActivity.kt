package com.alexander.bitcoindb1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.alexander.bitcoindb1.databinding.ActivityMainBinding
import com.anychart.charts.Cartesian
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), MainContract.View {

    var presenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = MainPresenter(this, this)
        presenter!!.init()
        presenter!!.getBitcoinPriceList()
    }

    override fun bindingView() {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun showLastBitcoinPrice() {
        TODO("Not yet implemented")
    }

    override fun showBitcoinPriceChart() {
        TODO("Not yet implemented")
    }

    override fun setLastBitcoinPrice(bitcoinPrice: BitcoinPrice) {
        last_bitcoin_price.text = bitcoinPrice.price.toString()
    }

    override fun setBitcoinPriceChart(cartesian: Cartesian) {
        any_chart_view.setChart(cartesian)
    }
}