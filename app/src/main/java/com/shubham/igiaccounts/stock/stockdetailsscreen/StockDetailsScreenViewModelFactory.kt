package com.shubham.igiaccounts.stock.stockdetailsscreen

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shubham.igiaccounts.database.stock.StockDatabaseDao

class StockDetailsScreenViewModelFactory(
    private val dataSource: StockDatabaseDao,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StockDetailsScreenViewModel::class.java)) {
            return StockDetailsScreenViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}