package com.shubham.igiaccounts.database.saledetails

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sale_details_data_table")
class SaleDetails(
    @PrimaryKey(autoGenerate = true)
    var saleDetailsId: Long = 0L,

    @ColumnInfo(name = "sale_details_sale_id")
    var saleDetailsSaleId: Long = 0L,

    @ColumnInfo(name = "sale_details_customer")
    var saleDetailsCustomer: String = "",

    @ColumnInfo(name = "sale_details_item")
    var saleDetailsItem: String = "",

    @ColumnInfo(name = "sale_details_quantity")
    var saleDetailsQuantity: Float = 0.0F,

    @ColumnInfo(name = "sale_details_rate")
    var saleDetailsRate: Float = 0.0F,

    @ColumnInfo(name = "sale_details_percentage")
    var saleDetailsPercentage: Float = 0.0F,

    @ColumnInfo(name = "sale_details_total")
    var saleDetailsTotal: Float = 0.0F
)