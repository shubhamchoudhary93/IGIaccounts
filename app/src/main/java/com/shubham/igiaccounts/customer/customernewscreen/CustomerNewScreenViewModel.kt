package com.shubham.igiaccounts.customer.customernewscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.shubham.igiaccounts.database.customer.CustomerDatabaseDao

class CustomerNewScreenViewModel(
    val database: CustomerDatabaseDao,
    application: Application
) : AndroidViewModel(application)