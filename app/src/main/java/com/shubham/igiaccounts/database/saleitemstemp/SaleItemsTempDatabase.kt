package com.shubham.igiaccounts.database.saleitemstemp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SaleItemsTemp::class], version = 1, exportSchema = false)
abstract class SaleItemsTempDatabase : RoomDatabase() {

    abstract val saleItemsTempDatabaseDao: SaleItemsTempDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: SaleItemsTempDatabase? = null

        fun getInstance(context: Context): SaleItemsTempDatabase {
            synchronized(this) {

                var instance =
                    INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SaleItemsTempDatabase::class.java,
                        "saleitemstemp_data_table"
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