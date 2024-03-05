package com.ptitsa_chebupitsa.onvector.data.db

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CurrencyItemDbModel::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract fun currencyListDao(): ConvectorDao

    companion object {
        private var INSTANCE: AppDataBase? = null
        private val LOOK = Any()
        private const val DB_NAME = "convector_item.db"

        fun getInsert(application: Application): AppDataBase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOOK) {
                INSTANCE?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    application,
                    AppDataBase::class.java,
                    DB_NAME
                ).build()
                INSTANCE = db
                return db
            }

        }

    }
}