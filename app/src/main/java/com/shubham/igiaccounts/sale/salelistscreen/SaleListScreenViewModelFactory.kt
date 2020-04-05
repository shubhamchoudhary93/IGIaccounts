package com.shubham.igiaccounts.sale.salelistscreen

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shubham.igiaccounts.database.sale.SaleDatabaseDao

class SaleListScreenViewModelFactory(
    private val dataSource: SaleDatabaseDao,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SaleListScreenViewModel::class.java)) {
            return SaleListScreenViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}