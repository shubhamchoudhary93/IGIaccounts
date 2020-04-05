package com.shubham.igiaccounts.customer.customermodifyscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.shubham.igiaccounts.database.customer.CustomerDatabaseDao

class CustomerModifyScreenViewModel(
    val database: CustomerDatabaseDao,
    application: Application
) : AndroidViewModel(application)