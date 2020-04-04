package com.shubham.igiaccounts.database.stock

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface StockDatabaseDao {
    @Insert
    fun insert(stock: Stock)

    @Update
    fun update(stock: Stock)

    @Query("SELECT * from Stock_data_table WHERE StockId = :id")
    fun get(id: Long): Stock?

    @Query("DELETE FROM Stock_data_table")
    fun clear()

    @Query("SELECT * FROM Stock_data_table ORDER BY StockId DESC")
    fun getAllStocks(): LiveData<List<Stock>>

    @Query("SELECT * FROM Stock_data_table ORDER BY StockId DESC LIMIT 1")
    fun getLastStock(): Stock?

}