package com.shubham.igiaccounts.database.saletemp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "sale_temp_data_table")
class SaleTemp(
    @PrimaryKey(autoGenerate = true)
    var saleTempId: Long = 0L,

    @ColumnInfo(name = "sale_temp_date")
    val saleTempDate: String = Date().toString(),

    @ColumnInfo(name = "sale_temp_sale_details_id")
    var saleSaleTempDetailsID: Long = 0L,

    @ColumnInfo(name = "sale_temp_no_of_items")
    var saleTempNoOfItems: Long = 0L,

    @ColumnInfo(name = "sale_temp_amount")
    var saleTempAmount: Float = 0.0F,

    @ColumnInfo(name = "sale_temp_current_balance")
    var saleTempCash: Boolean = false,

    @ColumnInfo(name = "sale_temp_customer_id")
    var saleTempCustomerID: Long = 0L
)