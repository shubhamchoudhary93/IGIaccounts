package com.shubham.igiaccounts.sale.saledetailsscreen

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shubham.igiaccounts.database.sale.SaleDatabaseDao

class SaleDetailsScreenViewModelFactory(
    private val dataSource: SaleDatabaseDao,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SaleDetailsScreenViewModel::class.java)) {
            return SaleDetailsScreenViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}