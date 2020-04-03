package com.shubham.igiaccounts.database.stock

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stock_data_table")
class Stock(
    @PrimaryKey(autoGenerate = true)
    var stockId: Long = 0L,

    @ColumnInfo(name = "stock_name")
    val stockName: String = "",

    @ColumnInfo(name = "stock_category_name")
    var stockCategoryName: String = "",

    @ColumnInfo(name = "stock_rate")
    var stockRate: Float = 0.0F,

    @ColumnInfo(name = "stock_percentage")
    var stockPercentage: Float = 0.0F
)