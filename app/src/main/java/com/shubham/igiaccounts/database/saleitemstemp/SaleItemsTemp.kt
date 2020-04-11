package com.shubham.igiaccounts.database.saleitemstemp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "saleitemstemp_data_table")
class SaleItemsTemp(
    @PrimaryKey(autoGenerate = true)
    var saleitemstempId: Long = 0L,

    @ColumnInfo(name = "sale_items_temp_item")
    var saleitemstempitem: String = "",

    @ColumnInfo(name = "sale_items_temp_customer")
    var saleitemstempCustomer: String = "",

    @ColumnInfo(name = "sale_items_temp_quantity")
    var saleitemstempQuantity: Float = 0.0F,

    @ColumnInfo(name = "sale_items_temp_rate")
    var saleitemstempRate: Float = 0.0F,

    @ColumnInfo(name = "sale_items_temp_percentage")
    var saleitemstempPercentage: Float = 0.0F,

    @ColumnInfo(name = "sale_items_temp_total")
    var saleitemstempTotal: Float = 0.0F

)