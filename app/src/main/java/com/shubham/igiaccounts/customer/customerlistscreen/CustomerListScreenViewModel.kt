package com.shubham.igiaccounts.customer.customerlistscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.shubham.igiaccounts.database.customer.CustomerDatabaseDao

class CustomerListScreenViewModel(
    val database: CustomerDatabaseDao,
    application: Application
) : AndroidViewModel(application)