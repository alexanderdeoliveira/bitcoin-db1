package com.alexander.bitcoindb1.view

import android.content.res.Resources
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
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


class MainActivity : AppCompatActivity(), MainContract.View, AdapterView.OnItemSelectedListener {

    private val presenter by lazy {
        lifecycleScope.get<MainContract.Presenter> { parametersOf(this) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter.init()
        presenter.getBitcoinPriceList(null)
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

    override fun setBitcoinChart(cartesian: Cartesian) {
        any_chart_view.setProgressBar(progress)
        any_chart_view.setChart(cartesian)
    }

    override fun setSpinner() {
        ArrayAdapter.createFromResource(
            this,
            R.array.time_span_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner_timespan.onItemSelectedListener = this
            spinner_timespan.adapter = adapter
        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val timespanRequestArray = resources.getStringArray(R.array.time_span_array_request)
        presenter.onTimespanSelected(timespanRequestArray[p2])
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }
}