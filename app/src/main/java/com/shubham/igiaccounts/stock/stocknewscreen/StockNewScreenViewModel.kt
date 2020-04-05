package com.shubham.igiaccounts.stock.stocknewscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.shubham.igiaccounts.database.stock.StockDatabaseDao

class StockNewScreenViewModel(
    val database: StockDatabaseDao,
    application: Application
) : AndroidViewModel(application)