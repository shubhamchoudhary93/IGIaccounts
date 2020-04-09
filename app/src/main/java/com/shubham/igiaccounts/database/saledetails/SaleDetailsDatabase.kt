package com.shubham.igiaccounts.database.saledetails

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SaleDetails::class], version = 1, exportSchema = false)
abstract class SaleDetailsDatabase : RoomDatabase() {

    abstract val saleDetailsDatabaseDao: SaleDetailsDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: SaleDetailsDatabase? = null

        fun getInstance(context: Context): SaleDetailsDatabase {
            synchronized(this) {

                var instance =
                    INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SaleDetailsDatabase::class.java,
                        "sale_details_data_table"
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