package com.shubham.igiaccounts.customer.customerdetailsscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.shubham.igiaccounts.database.customer.CustomerDatabaseDao

class CustomerDetailsScreenViewModel(
    val database: CustomerDatabaseDao,
    application: Application
) : AndroidViewModel(application)