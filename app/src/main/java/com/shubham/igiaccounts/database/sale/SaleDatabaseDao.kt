package com.shubham.igiaccounts.database.sale

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface SaleDatabaseDao {
    @Insert
    fun insert(customer: Customer)

    @Update
    fun update(customer: Customer)

    @Query("SELECT * from customer_data_table WHERE customerId = :id")
    fun get(id: Long): Customer?

    @Query("DELETE FROM customer_data_table")
    fun clear()

    @Query("SELECT * FROM customer_data_table ORDER BY customerId DESC")
    fun getAllNights(): LiveData<List<Customer>>

    @Query("SELECT * FROM customer_data_table ORDER BY customerId DESC LIMIT 1")
    fun getTonight(): Customer?

}