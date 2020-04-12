package com.shubham.igiaccounts.database.saledetails

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface SaleDetailsDatabaseDao {
    @Insert
    fun insert(saleDetails: SaleDetails)

    @Update
    fun update(saleDetails: SaleDetails)

    @Query("SELECT * from sale_details_data_table WHERE SaleDetailsId = :id")
    fun get(id: Long): SaleDetails?

    @Query("DELETE FROM sale_details_data_table")
    fun clear()

    @Query("SELECT * FROM sale_details_data_table ORDER BY SaleDetailsId DESC")
    fun getAllSaleDetails(): LiveData<List<SaleDetails>>

    @Query("SELECT * FROM sale_details_data_table ORDER BY SaleDetailsId DESC LIMIT 1")
    fun getLastSaleDetails(): SaleDetails?

    @Query("SELECT sale_details_total FROM sale_details_data_table")
    fun getTotals(): List<Float>

    @Query("SELECT SaleDetailsId FROM sale_details_data_table ORDER BY SaleDetailsId DESC LIMIT 1")
    fun getLastSaleDetailsID(): Long

    @Query("UPDATE sale_details_data_table SET sale_details_sale_id = :saleId WHERE SaleDetailsId = :saleDetailsId ")
    fun updateSaleDetailsId(saleDetailsId: Long, saleId: Long)
}