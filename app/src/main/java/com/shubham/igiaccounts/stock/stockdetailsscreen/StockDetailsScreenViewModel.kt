package com.shubham.igiaccounts.stock.stockdetailsscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.shubham.igiaccounts.database.stock.StockDatabaseDao

class StockDetailsScreenViewModel(
    val database: StockDatabaseDao,
    application: Application
) : AndroidViewModel(application)