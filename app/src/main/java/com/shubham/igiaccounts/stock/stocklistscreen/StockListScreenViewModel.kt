package com.shubham.igiaccounts.stock.stocklistscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Transformations
import com.shubham.igiaccounts.database.stock.StockDatabaseDao
import com.shubham.igiaccounts.formatStockList

class StockListScreenViewModel(
    val database: StockDatabaseDao,
    application: Application
) : AndroidViewModel(application) {
    private var stocks = database.getAllStocks()

    val stockString =
        Transformations.map(stocks) { stocks -> formatStockList(stocks) }

}