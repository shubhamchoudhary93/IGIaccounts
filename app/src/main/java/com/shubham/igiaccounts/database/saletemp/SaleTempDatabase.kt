package com.shubham.igiaccounts.database.saletemp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SaleTemp::class], version = 1, exportSchema = false)
abstract class SaleTempDatabase : RoomDatabase() {

    abstract val saleDatabaseDao: SaleTempDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: SaleTempDatabase? = null

        fun getInstance(context: Context): SaleTempDatabase {
            synchronized(this) {

                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SaleTempDatabase::class.java,
                        "sale_temp_data_table"
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