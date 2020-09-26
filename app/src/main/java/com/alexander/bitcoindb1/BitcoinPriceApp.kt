package com.alexander.bitcoindb1

import android.app.Application
import com.alexander.bitcoindb1.di.daoModule
import com.alexander.bitcoindb1.di.databaseModule
import com.alexander.bitcoindb1.di.instance
import com.alexander.bitcoindb1.di.network
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BitcoinPriceApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BitcoinPriceApp)
            modules(listOf(
                databaseModule,
                instance,
                network,
                daoModule
            ))
        }
    }
}
