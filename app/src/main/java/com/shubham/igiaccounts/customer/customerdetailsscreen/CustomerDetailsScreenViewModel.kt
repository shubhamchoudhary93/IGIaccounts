package com.shubham.igiaccounts.customer.customerdetailsscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.shubham.igiaccounts.database.customer.Customer
import com.shubham.igiaccounts.database.customer.CustomerDatabaseDao
import kotlinx.coroutines.*

class CustomerDetailsScreenViewModel(
    val database: CustomerDatabaseDao,
    application: Application
) : AndroidViewModel(application) {

    var liveC = MutableLiveData<Boolean>()
    var customer = Customer()

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    init {
        liveC.value = false
    }

    fun fetchCustomer(customerId: Long) {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                customer = if (customerId == 0L) {
                    try {
                        database.getLastCustomer()
                    } catch (e: Exception) {
                        e.printStackTrace()
                        Customer()
                    }
                } else {
                    try {
                        database.get(customerId)!!
                    } catch (e: Exception) {
                        e.printStackTrace()
                        Customer()
                    }
                }

            }
            liveC.value = true
        }
    }

    fun deleteCustomer(customerId: Long) {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    database.delete(customerId)
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