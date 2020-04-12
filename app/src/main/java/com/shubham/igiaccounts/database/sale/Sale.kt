package com.shubham.igiaccounts.database.sale

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "sale_data_table")
class Sale(
    @PrimaryKey(autoGenerate = true)
    var saleId: Long = 0L,

    @ColumnInfo(name = "sale_cash")
    var saleCash: Boolean = false,

    @ColumnInfo(name = "sale_date")
    val saleDate: String = Date().toString(),

    @ColumnInfo(name = "sale_customer")
    var saleCustomer: String = "",

    @ColumnInfo(name = "sale_transport")
    var saleTransport: Float = 0.0F,

    @ColumnInfo(name = "sale_other_charges")
    var saleOtherCharges: Float = 0.0F,

    @ColumnInfo(name = "sale_amount")
    var saleAmount: Float = 0.0F
)