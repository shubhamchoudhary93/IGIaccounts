package com.shubham.igiaccounts.transaction.transactiondetailsscreen

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shubham.igiaccounts.database.transaction.TransactionDatabaseDao

class TransactionDetailsScreenViewModelFactory(
    private val dataSource: TransactionDatabaseDao,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TransactionDetailsScreenViewModel::class.java)) {
            return TransactionDetailsScreenViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}