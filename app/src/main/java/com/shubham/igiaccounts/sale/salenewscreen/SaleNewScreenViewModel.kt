package com.shubham.igiaccounts.sale.salenewscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.shubham.igiaccounts.database.sale.SaleDatabaseDao

class SaleNewScreenViewModel(
    val database: SaleDatabaseDao,
    application: Application
) : AndroidViewModel(application)