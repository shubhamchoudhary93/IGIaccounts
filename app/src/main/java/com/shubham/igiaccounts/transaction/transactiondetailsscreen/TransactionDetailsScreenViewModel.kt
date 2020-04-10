package com.shubham.igiaccounts.transaction.transactiondetailsscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.shubham.igiaccounts.database.customer.CustomerDatabase
import com.shubham.igiaccounts.database.transaction.Transaction
import com.shubham.igiaccounts.database.transaction.TransactionDatabaseDao
import kotlinx.coroutines.*

class TransactionDetailsScreenViewModel(
    val database: TransactionDatabaseDao,
    application: Application
) : AndroidViewModel(application) {

    var liveC = MutableLiveData<Boolean>()
    var transaction = Transaction()
    var customername = "god"

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    val database1 = CustomerDatabase.getInstance(application).customerDatabaseDao
    init {
        liveC.value = false
    }

    fun fetchTransaction(transactionId: Long) {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                transaction = if (transactionId == 0L) {
                    try {
                        database.getLastTransaction()
                    } catch (e: Exception) {
                        e.printStackTrace()
                        Transaction()
                    }
                } else {
                    try {
                        database.get(transactionId)!!
                    } catch (e: Exception) {
                        e.printStackTrace()
                        Transaction()
                    }
                }
                customername =
                    withContext(Dispatchers.IO) { database1.searchCustomerName(transaction.transactionCustomerId)!! }
            }
            liveC.value = true
        }
    }

    fun deleteTransaction(transactionId: Long) {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    database.delete(transactionId)
                } catch (e: Exception) {
                    e.printStackTrace()

                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}