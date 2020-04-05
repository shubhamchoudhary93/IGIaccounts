package com.shubham.igiaccounts.customer.customerlistofsalescreen

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shubham.igiaccounts.database.customer.CustomerDatabaseDao

class CustomerListOfSaleScreenViewModelFactory(
    private val dataSource: CustomerDatabaseDao,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CustomerListOfSaleScreenViewModel::class.java)) {
            return CustomerListOfSaleScreenViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}