package com.shubham.igiaccounts.database.sale

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Sale::class], version = 1, exportSchema = false)
abstract class SaleDatabase : RoomDatabase() {

    abstract val saleDatabaseDao: SaleDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: SaleDatabase? = null

        fun getInstance(context: Context): SaleDatabase {
            synchronized(this) {

                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SaleDatabase::class.java,
                        "sale_data_table"
                    )

                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}