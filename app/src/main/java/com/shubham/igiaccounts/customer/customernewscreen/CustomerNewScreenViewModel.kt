package com.shubham.igiaccounts.customer.customernewscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.shubham.igiaccounts.database.customer.Customer
import com.shubham.igiaccounts.database.customer.CustomerDatabaseDao
import kotlinx.coroutines.*

class CustomerNewScreenViewModel(
    val database: CustomerDatabaseDao,
    application: Application
) : AndroidViewModel(application) {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun insertCustomer(name: String, phone: Long, address: String, openingbalance: Float) {
        uiScope.launch {
            val customer = Customer()
            customer.customerName = name
            customer.customerPhone = phone
            customer.customerAddress = address
            customer.customerOpeningBalance = openingbalance
            insert(customer)
        }
    }

    private suspend fun insert(customer: Customer) {
        withContext(Dispatchers.IO) {
            database.insert(customer)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}