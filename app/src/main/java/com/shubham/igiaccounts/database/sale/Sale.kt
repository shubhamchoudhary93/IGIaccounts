package com.shubham.igiaccounts.database.sale

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "sale_data_table")
class Sale(
    @PrimaryKey(autoGenerate = true)
    var saleId: Long = 0L,

    @ColumnInfo(name = "sale_date")
    val saleDate: String = Date().toString(),

    @ColumnInfo(name = "sale_sale_details_id")
    var saleSaleDetailsID: Long = 0L,

    @ColumnInfo(name = "sale_no_of_items")
    var saleNoOfItems: Long = 0L,

    @ColumnInfo(name = "sale_amount")
    var saleAmount: Float = 0.0F,

    @ColumnInfo(name = "sale_current_balance")
    var saleCash: Boolean = false,

    @ColumnInfo(name = "sale_customer_id")
    var saleCustomerID: Long = 0L
)