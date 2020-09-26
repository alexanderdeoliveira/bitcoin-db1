package com.alexander.bitcoindb1.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alexander.bitcoindb1.model.BitcoinPrice

@Database(entities = arrayOf(BitcoinPrice::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bitcoinpPriceDAO(): BitcoinPriceDAO

//    companion object {
//        @Volatile
//        private var INSTANCE: AppDatabase? = null
//
//        fun getDatabase(context: Context): AppDatabase {
//            val tempInstance = INSTANCE
//            if (tempInstance != null) {
//                return tempInstance
//            }
//            synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    AppDatabase::class.java,
//                    "app_database"
//                ).allowMainThreadQueries().build()
//                INSTANCE = instance
//                return instance
//            }
//        }
//    }
}