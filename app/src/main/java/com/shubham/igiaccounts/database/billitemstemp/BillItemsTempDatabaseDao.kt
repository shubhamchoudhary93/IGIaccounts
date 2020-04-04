package com.shubham.igiaccounts.database.billitemstemp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface BillItemsTempDatabaseDao {
    @Insert
    fun insert(customer: BillItemsTemp)

    @Update
    fun update(customer: BillItemsTemp)

    @Query("SELECT * from billitemstemp_data_table WHERE billitemstempId = :id")
    fun get(id: Long): BillItemsTemp?

    @Query("DELETE FROM billitemstemp_data_table")
    fun clear()

    @Query("SELECT * FROM billitemstemp_data_table ORDER BY billitemstempId DESC")
    fun getAllItems(): LiveData<List<BillItemsTemp>>

    @Query("SELECT * FROM billitemstemp_data_table ORDER BY billitemstempId DESC LIMIT 1")
    fun getLastItem(): BillItemsTemp?

}