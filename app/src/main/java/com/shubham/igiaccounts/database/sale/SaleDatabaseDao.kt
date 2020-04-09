package com.shubham.igiaccounts.database.sale

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface SaleDatabaseDao {
    @Insert
    fun insert(sale: Sale)

    @Update
    fun update(sale: Sale)

    @Query("SELECT * from sale_data_table WHERE saleId = :id")
    fun get(id: Long): Sale?

    @Query("DELETE FROM sale_data_table WHERE saleId = :id")
    fun delete(id: Long)

    @Query("DELETE FROM sale_data_table")
    fun clear()

    @Query("SELECT * FROM sale_data_table ORDER BY saleId DESC")
    fun getAllSales(): LiveData<List<Sale>>

    @Query("SELECT * FROM sale_data_table ORDER BY saleId DESC LIMIT 1")
    fun getLastCustomer(): Sale

    @Query("SELECT * FROM sale_data_table WHERE sale_date LIKE :searchText")
    fun searchSale(searchText: String): LiveData<List<Sale>>

}