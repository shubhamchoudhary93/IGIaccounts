package com.shubham.igiaccounts.database.customer

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CustomerDatabaseDao {
    @Insert
    fun insert(customer: Customer)

    @Update
    fun update(customer: Customer)

    @Query("SELECT * from customer_data_table WHERE customerId = :id")
    fun get(id: Long): Customer?

    @Query("DELETE FROM customer_data_table WHERE customerId = :id")
    fun delete(id: Long)

    @Query("DELETE FROM customer_data_table")
    fun clear()

    @Query("SELECT * FROM customer_data_table ORDER BY customerId DESC")
    fun getAllCustomer(): LiveData<List<Customer>>

    @Query("SELECT * FROM customer_data_table ORDER BY customerId DESC LIMIT 1")
    fun getLastCustomer(): Customer

    @Query("SELECT * FROM customer_data_table WHERE customer_name LIKE :searchText")
    fun searchCustomer(searchText: String): LiveData<List<Customer>>
}