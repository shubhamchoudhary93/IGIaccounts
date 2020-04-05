package com.shubham.igiaccounts.transaction.transactionmodifyscreen

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shubham.igiaccounts.database.transaction.TransactionDatabaseDao

class TransactionModifyScreenViewModelFactory(
    private val dataSource: TransactionDatabaseDao,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TransactionModifyScreenViewModel::class.java)) {
            return TransactionModifyScreenViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}