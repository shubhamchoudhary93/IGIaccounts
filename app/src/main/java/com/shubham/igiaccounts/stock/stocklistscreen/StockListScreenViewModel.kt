package com.shubham.igiaccounts.stock.stocklistscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.shubham.igiaccounts.database.stock.StockDatabaseDao

class StockListScreenViewModel(
    val database: StockDatabaseDao,
    application: Application
) : AndroidViewModel(application)