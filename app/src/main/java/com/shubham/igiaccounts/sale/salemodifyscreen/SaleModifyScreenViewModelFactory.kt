package com.shubham.igiaccounts.sale.salemodifyscreen

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shubham.igiaccounts.database.sale.SaleDatabaseDao

class SaleModifyScreenViewModelFactory(
    private val dataSource: SaleDatabaseDao,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SaleModifyScreenViewModel::class.java)) {
            return SaleModifyScreenViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}