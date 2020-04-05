package com.shubham.igiaccounts.customer.customerlistoftransactionscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.shubham.igiaccounts.database.customer.CustomerDatabaseDao

class CustomerListOfTransactionScreenViewModel(
    val database: CustomerDatabaseDao,
    application: Application
) : AndroidViewModel(application)