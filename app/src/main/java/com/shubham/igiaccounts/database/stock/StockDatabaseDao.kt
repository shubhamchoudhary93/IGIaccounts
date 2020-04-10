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
    fun getLastStock(): Stock

    @Query("DELETE FROM Stock_data_table WHERE StockId = :id")
    fun delete(id: Long)

    @Query("SELECT * FROM Stock_data_table WHERE StockId LIKE :searchText")
    fun searchStock(searchText: String): LiveData<List<Stock>>

    @Query("SELECT stockId FROM Stock_data_table WHERE stock_name = :searchText")
    fun searchStockID(searchText: String): Long


}