package com.shubham.igiaccounts.database.saleitemstemp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface SaleItemsTempDatabaseDao {
    @Insert
    fun insert(saleitemtemp: SaleItemsTemp)

    @Update
    fun update(saleitemtemp: SaleItemsTemp)

    @Query("SELECT * from saleitemstemp_data_table WHERE saleitemstempId = :id")
    fun get(id: Long): SaleItemsTemp?

    @Query("DELETE FROM saleitemstemp_data_table")
    fun clear()

    @Query("SELECT * FROM saleitemstemp_data_table ORDER BY saleitemstempId DESC")
    fun getAllItems(): LiveData<List<SaleItemsTemp>>

    @Query("SELECT * FROM saleitemstemp_data_table ORDER BY saleitemstempId DESC LIMIT 1")
    fun getLastItem(): SaleItemsTemp?

    @Query("SELECT sale_items_temp_total FROM saleitemstemp_data_table")
    fun gettotals(): List<Float>
}