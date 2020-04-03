package com.shubham.igiaccounts.database.transaction

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transaction_data_table")
class Transaction(
    @PrimaryKey(autoGenerate = true)
    var transactionId: Long = 0L,

    @ColumnInfo(name = "transaction_name")
    val transactionName: String = "",

    @ColumnInfo(name = "transaction_phone")
    var transactionPhone: Long = 0L,

    @ColumnInfo(name = "transaction_address")
    var transactionAddress: String = "",

    @ColumnInfo(name = "transaction_opening_balance")
    var transactionOpeningBalance: Float = 0.0F,

    @ColumnInfo(name = "transaction_current_balance")
    var transactionCurrentBalance: Float = 0.0F
)