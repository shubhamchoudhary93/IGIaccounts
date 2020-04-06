package com.shubham.igiaccounts.database.customer

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "customer_data_table")
class Customer(
    @PrimaryKey(autoGenerate = true)
    var customerId: Long = 0L,

    @ColumnInfo(name = "customer_name")
    var customerName: String = "",

    @ColumnInfo(name = "customer_phone")
    var customerPhone: Long = 0L,

    @ColumnInfo(name = "customer_address")
    var customerAddress: String = "",

    @ColumnInfo(name = "customer_opening_balance")
    var customerOpeningBalance: Float = 0.0F,

    @ColumnInfo(name = "customer_current_balance")
    var customerCurrentBalance: Float = 0.0F
)