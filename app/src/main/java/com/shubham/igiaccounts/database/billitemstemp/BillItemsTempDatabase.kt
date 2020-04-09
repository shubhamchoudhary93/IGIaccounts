package com.shubham.igiaccounts.database.billitemstemp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BillItemsTemp::class], version = 1, exportSchema = false)
abstract class BillItemsTempDatabase : RoomDatabase() {

    abstract val billItemsTempDatabaseDao: BillItemsTempDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: BillItemsTempDatabase? = null

        fun getInstance(context: Context): BillItemsTempDatabase {
            synchronized(this) {

                var instance =
                    INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BillItemsTempDatabase::class.java,
                        "billitemstemp_data_table"
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