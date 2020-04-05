package com.shubham.igiaccounts.sale.salenewitemaddscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.shubham.igiaccounts.database.sale.SaleDatabaseDao

class SaleNewItemAddScreenViewModel(
    val database: SaleDatabaseDao,
    application: Application
) : AndroidViewModel(application)