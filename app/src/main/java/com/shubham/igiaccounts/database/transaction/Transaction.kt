package com.shubham.igiaccounts.database.transaction

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "transaction_data_table")
class Transaction(
    @PrimaryKey(autoGenerate = true)
    var transactionId: Long = 0L,

    @ColumnInfo(name = "transaction_receipt")
    var receipt: Boolean = true,

    @ColumnInfo(name = "transaction_customer")
    var transactionCustomer: String = "",

    @ColumnInfo(name = "transaction_amount")
    var transactionAmount: Float = 0.0F,

    @ColumnInfo(name = "transaction_date")
    var transactionDate: String = Date().toString(),

    @ColumnInfo(name = "transaction_detail")
    var transactionDetail: String = ""
)