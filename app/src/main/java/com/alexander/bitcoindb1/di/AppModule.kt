package com.alexander.bitcoindb1.di

import androidx.room.Room
import com.alexander.bitcoindb1.repository.BitcoinPriceRepository
import com.alexander.bitcoindb1.view.MainActivity
import com.alexander.bitcoindb1.contract.MainContract
import com.alexander.bitcoindb1.presenter.MainPresenter
import com.alexander.bitcoindb1.database.AppDatabase
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val databaseModule = module {
    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "app_database"
        ).allowMainThreadQueries().build()
    }
}

val network = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://api.blockchain.info")
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

val daoModule = module {
    single { get<AppDatabase>().bitcoinpPriceDAO() }

    single { BitcoinPriceRepository(get(), get()) }
}

val instance = module {
    scope(named<MainActivity>()) {
        factory<MainContract.Presenter> { (view: MainContract.View)  ->
            MainPresenter(view, get())
        }
    }
}