package com.alexander.bitcoindb1

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainPresenter(
    private val mView: MainContract.View,
): MainContract.Presenter {

    private var disposable = CompositeDisposable()
    private var repository = BitcoinPriceRepository()

    override fun getBitcoinPriceList() {
        disposable.add(
            repository.requestBitcoinPriceList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe { bitcoinPriceList ->
                    mView.setBitcoinPriceList(bitcoinPriceList)
                }
        )
    }
}