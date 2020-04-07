package com.shubham.igiaccounts.customer.customerlistscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Transformations
import com.shubham.igiaccounts.database.customer.CustomerDatabaseDao
import com.shubham.igiaccounts.formatCustomerList
import kotlinx.coroutines.*

class CustomerListScreenViewModel(
    val database: CustomerDatabaseDao,
    application: Application
) : AndroidViewModel(application) {
    private var viewModelJob = Job()
    private var customers = database.getAllCustomer()

    val customersString =
        Transformations.map(customers) { customers -> formatCustomerList(customers) }

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun searchCustomer(searchText: String) {
        uiScope.launch {
            var searchText1 = "%$searchText%"
            println(searchText1)
            searching(searchText1)
        }
    }

    private suspend fun searching(searchText: String) {
        withContext(Dispatchers.IO) {
            customers = database.getAllCustomer()
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }


}