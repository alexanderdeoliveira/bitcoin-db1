package com.alexander.bitcoindb1.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.alexander.bitcoindb1.R
import com.alexander.bitcoindb1.contract.MainContract
import com.alexander.bitcoindb1.databinding.ActivityMainBinding
import com.alexander.bitcoindb1.model.BitcoinPrice
import com.anychart.charts.Cartesian
import com.google.android.material.snackbar.Snackbar
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
        last_bitcoin_price.isVisible = true
    }

    override fun showBitcoinPriceChart() {
        any_chart_view.isVisible = true
    }

    override fun showSnackbarError() {
        val snackbar = Snackbar.make(layout , R.string.request_error_message, Snackbar.LENGTH_SHORT)
        snackbar.show()
    }

    override fun setLastBitcoinPrice(bitcoinPrice: BitcoinPrice) {
        last_bitcoin_price.text = bitcoinPrice.price.toString()
    }

    override fun setBitcoinPriceChart(cartesian: Cartesian) {
        any_chart_view.setChart(cartesian)
    }
}