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

    fun fetchLastCustomer() {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                customer = this@CustomerDetailsScreenViewModel.database.getLastCustomer()
            }
            liveC.value = true
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}