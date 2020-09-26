package com.alexander.bitcoindb1.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alexander.bitcoindb1.contract.MainContract
import com.alexander.bitcoindb1.databinding.ActivityMainBinding
import com.alexander.bitcoindb1.model.BitcoinPrice
import com.anychart.charts.Cartesian
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.scope.lifecycleScope
import org.koin.core.parameter.parametersOf


class MainActivity : AppCompatActivity(), MainContract.View {

    private val presenter by lazy {
        lifecycleScope.get<MainContract.Presenter> { parametersOf(this) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter.init()
        presenter.getBitcoinPriceList()
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