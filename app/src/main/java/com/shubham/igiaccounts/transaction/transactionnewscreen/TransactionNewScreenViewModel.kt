package com.shubham.igiaccounts.transaction.transactionnewscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.shubham.igiaccounts.database.transaction.Transaction
import com.shubham.igiaccounts.database.transaction.TransactionDatabaseDao
import kotlinx.coroutines.*

class TransactionNewScreenViewModel(
    val database1: TransactionDatabaseDao,
    application: Application
) : AndroidViewModel(application) {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun insertTransaction(customerId: Long, amount: Float, date: String, detail: String) {
        uiScope.launch {
            val transaction = Transaction()
            transaction.transactionCustomerId = customerId

            transaction.transactionAmount = amount
            transaction.transactionDate = date
            transaction.transactionDetail = detail
            insert(transaction)
        }
    }

    private suspend fun insert(transaction: Transaction) {
        withContext(Dispatchers.IO) {
            database1.insert(transaction)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}