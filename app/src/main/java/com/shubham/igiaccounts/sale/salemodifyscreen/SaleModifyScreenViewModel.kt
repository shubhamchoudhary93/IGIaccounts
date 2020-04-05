package com.shubham.igiaccounts.sale.salemodifyscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.shubham.igiaccounts.database.sale.SaleDatabaseDao

class SaleModifyScreenViewModel(
    val database: SaleDatabaseDao,
    application: Application
) : AndroidViewModel(application)