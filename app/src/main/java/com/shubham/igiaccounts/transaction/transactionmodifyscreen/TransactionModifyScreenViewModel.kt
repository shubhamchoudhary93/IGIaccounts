package com.shubham.igiaccounts.transaction.transactionmodifyscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.shubham.igiaccounts.database.transaction.Transaction
import com.shubham.igiaccounts.database.transaction.TransactionDatabaseDao
import kotlinx.coroutines.*

class TransactionModifyScreenViewModel(
    val database: TransactionDatabaseDao,
    application: Application
) : AndroidViewModel(application) {

    var liveC = MutableLiveData<Boolean>()
    var transaction = Transaction()
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
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

            }
            liveC.value = true
        }
    }

    fun modifyTransaction(transaction1: Transaction) {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    transaction1.transactionId = transaction.transactionId
                    database.update(transaction1)
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