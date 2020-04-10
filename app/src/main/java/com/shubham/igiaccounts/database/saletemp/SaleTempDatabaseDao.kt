package com.shubham.igiaccounts.database.saletemp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface SaleTempDatabaseDao {
    @Insert
    fun insert(sale: SaleTemp)

    @Update
    fun update(sale: SaleTemp)

    @Query("SELECT * from sale_temp_data_table WHERE saleTempId = :id")
    fun get(id: Long): SaleTemp?

    @Query("DELETE FROM sale_temp_data_table WHERE saleTempId = :id")
    fun delete(id: Long)

    @Query("DELETE FROM sale_temp_data_table")
    fun clear()

    @Query("SELECT * FROM sale_temp_data_table ORDER BY saleTempId DESC")
    fun getAllSales(): LiveData<List<SaleTemp>>

    @Query("SELECT * FROM sale_temp_data_table ORDER BY saleTempId DESC LIMIT 1")
    fun getLastCustomer(): SaleTemp

    @Query("SELECT * FROM sale_temp_data_table WHERE sale_temp_customer_id LIKE :searchText")
    fun searchSale(searchText: Long): LiveData<List<SaleTemp>>

}