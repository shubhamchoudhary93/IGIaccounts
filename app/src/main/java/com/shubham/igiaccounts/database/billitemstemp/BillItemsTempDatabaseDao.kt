package com.shubham.igiaccounts.database.billitemstemp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface BillItemsTempDatabaseDao {
    @Insert
    fun insert(billitemtemp: BillItemsTemp)

    @Update
    fun update(billitemtemp: BillItemsTemp)

    @Query("SELECT * from billitemstemp_data_table WHERE billitemstempId = :id")
    fun get(id: Long): BillItemsTemp?

    @Query("DELETE FROM billitemstemp_data_table")
    fun clear()

    @Query("SELECT * FROM billitemstemp_data_table ORDER BY billitemstempId DESC")
    fun getAllItems(): LiveData<List<BillItemsTemp>>

    @Query("SELECT * FROM billitemstemp_data_table ORDER BY billitemstempId DESC LIMIT 1")
    fun getLastItem(): BillItemsTemp?

    @Query("SELECT bill_items_temp_total FROM billitemstemp_data_table")
    fun gettotals(): List<Float>
}