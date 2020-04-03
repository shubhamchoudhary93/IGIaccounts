package com.shubham.igiaccounts.database.billitemstemp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "billitemstemp_data_table")
class BillItemsTemp(
    @PrimaryKey(autoGenerate = true)
    var billitemstempId: Long = 0L,

    @ColumnInfo(name = "bill_items_temp_current_balance")
    var billitemstempCustomerID: Long = 0L,

    @ColumnInfo(name = "bill_items_temp_quantity")
    var billitemstempQuantity: Float = 0.0F,

    @ColumnInfo(name = "bill_items_temp_rate")
    var billitemstempRate: Float = 0.0F,

    @ColumnInfo(name = "bill_items_temp_percentage")
    var billitemstempPercentage: Float = 0.0F,

    @ColumnInfo(name = "bill_items_temp_total")
    var billitemstempTotal: Float = 0.0F

)