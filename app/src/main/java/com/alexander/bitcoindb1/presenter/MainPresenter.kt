package com.alexander.bitcoindb1.presenter

import com.alexander.bitcoindb1.contract.MainContract
import com.alexander.bitcoindb1.model.BitcoinPrice
import com.alexander.bitcoindb1.model.CustomDataChart
import com.alexander.bitcoindb1.repository.BitcoinPriceRepository
import com.alexander.bitcoindb1.util.DateUtil
import com.anychart.AnyChart
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.charts.Cartesian
import com.anychart.data.Set
import com.anychart.enums.Anchor
import com.anychart.enums.MarkerType
import com.anychart.enums.TooltipPositionMode
import com.anychart.graphics.vector.Stroke
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.ArrayList


class MainPresenter(
    private val mView: MainContract.View,
    private val repository: BitcoinPriceRepository
): MainContract.Presenter {

    private lateinit var disposable: CompositeDisposable

    override fun init() {
        disposable = CompositeDisposable()
        mView.bindingView()
    }

    override fun getBitcoinPriceList(timespan:String?) {
        disposable.add(
            repository.requestBitcoinPriceList(timespan)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnError {
                    mView.showSnackbarError()
                }
                .subscribe { response ->
                    repository.insertBitcoinPriceList(response.bitcoinPriceList)
                    mView.run {
                        setBitcoinChart(setCharCartesian(response.bitcoinPriceList))
                        setLastBitcoinPrice(response.bitcoinPriceList[response.bitcoinPriceList.size - 1])

                        showBitcoinPriceChart()
                        showLastBitcoinPrice()
                    }
                }
        )
    }

    override fun onTimespanSelected(timespan: String?) {
        TODO("Not yet implemented")
    }

    private fun setCharCartesian(bitcoinPriceList: List<BitcoinPrice>): Cartesian {
        val cartesian = AnyChart.line()

        val seriesData = ArrayList<DataEntry>()
        bitcoinPriceList.forEach {
            seriesData.add(CustomDataChart(DateUtil.convertLongToTime(it.time), it.price))
        }

        val set = Set.instantiate()
        set.data(seriesData)

        cartesian.animation(true)

        cartesian.padding(10.0, 20.0, 5.0, 20.0)

        cartesian.crosshair().enabled(true)
        cartesian.crosshair()
            .yLabel(true)
            .yStroke(null as Stroke?, null, null, null as String?, null as String?)

        cartesian.tooltip().positionMode(TooltipPositionMode.POINT)

        cartesian.yAxis(0).title("Price US$")
        cartesian.xAxis(0).labels().padding(5.0, 5.0, 5.0, 5.0)

        val series1Mapping = set.mapAs("{ x: 'x', value: 'value' }")

        val series1 = cartesian.line(series1Mapping)
        series1.name("Brandy")
        series1.hovered().markers().enabled(true)
        series1.hovered().markers()
            .type(MarkerType.CIRCLE)
            .size(4.0)
        series1.tooltip()
            .position("right")
            .anchor(Anchor.LEFT_CENTER)
            .offsetX(5.0)
            .offsetY(5.0)

        cartesian.legend().enabled(true)
        cartesian.legend().fontSize(13.0)
        cartesian.legend().padding(0.0, 0.0, 10.0, 0.0)

        return cartesian

    }
}