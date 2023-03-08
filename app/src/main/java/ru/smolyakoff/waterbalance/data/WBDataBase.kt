package ru.smolyakoff.waterbalance.data

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [UserItemDbModel::class,WaterItemDbModel::class],
    version = 1,
    exportSchema = false
)
abstract class WBDataBase : RoomDatabase() {

    abstract fun waterBalanceDao(): WaterBalanceDao

    companion object {

        private const val NAME_DATABASE = "water_balance.db"

        private var INSTANCE: WBDataBase? = null
        private val LOCK = Any()

        fun getInstance(application: Application): WBDataBase {

            INSTANCE?.let {
                return it
            }
            synchronized(LOCK){
                INSTANCE?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    application,
                    WBDataBase::class.java,
                    NAME_DATABASE
                ).build()
                INSTANCE = db
                return db
            }
        }


    }

}