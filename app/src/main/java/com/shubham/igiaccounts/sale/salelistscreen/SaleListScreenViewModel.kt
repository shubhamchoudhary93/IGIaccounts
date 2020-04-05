package com.shubham.igiaccounts.sale.salelistscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.shubham.igiaccounts.database.sale.SaleDatabaseDao

class SaleListScreenViewModel(
    val database: SaleDatabaseDao,
    application: Application
) : AndroidViewModel(application)