package com.shubham.igiaccounts.database.saledetails

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sale_details_data_table")
class SaleDetails(
    @PrimaryKey(autoGenerate = true)
    var saledetailsId: Long = 0L,

    @ColumnInfo(name = "saledetails_last_sale_item")
    val saledetailsLastsaleitem: Boolean = false,

    @ColumnInfo(name = "saledetails_stock_id")
    var saledetailsStock: String = "",

    @ColumnInfo(name = "saledetails_quantity")
    var saledetailsQuantity: Float = 0.0F,

    @ColumnInfo(name = "saledetails_rate")
    var saledetailsRate: Float = 0.0F,

    @ColumnInfo(name = "saledetails_percentage")
    var saledetailsPercentage: Float = 0.0F,

    @ColumnInfo(name = "saledetails_total")
    var saledetailsTotal: Float = 0.0F
)