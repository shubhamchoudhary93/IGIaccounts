package com.shubham.igiaccounts.database.transaction

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TransactionDatabaseDao {
    @Insert
    fun insert(transaction: Transaction)

    @Update
    fun update(transaction: Transaction)

    @Query("SELECT * from transaction_data_table WHERE transactionId = :id")
    fun get(id: Long): Transaction?

    @Query("DELETE FROM transaction_data_table WHERE transactionId = :id")
    fun delete(id: Long)

    @Query("DELETE FROM transaction_data_table")
    fun clear()

    @Query("SELECT * FROM transaction_data_table ORDER BY transactionId DESC")
    fun getAllTransactions(): LiveData<List<Transaction>>

    @Query("SELECT * FROM transaction_data_table ORDER BY transactionId DESC LIMIT 1")
    fun getLastTransaction(): Transaction

    @Query("SELECT * FROM transaction_data_table WHERE transaction_date LIKE :searchText")
    fun searchTransaction(searchText: String): LiveData<List<Transaction>>

}