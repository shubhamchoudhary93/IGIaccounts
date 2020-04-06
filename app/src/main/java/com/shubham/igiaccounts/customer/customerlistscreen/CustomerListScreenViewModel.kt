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
            withContext(Dispatchers.IO) {
                var searchText1 = "%$searchText%"
                println(searchText1)
                val customers = database.searchCustomer(searchText1)
                println("customers value")
                println(customers.value)
                println("customer string")
                println(customersString.value)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }


}