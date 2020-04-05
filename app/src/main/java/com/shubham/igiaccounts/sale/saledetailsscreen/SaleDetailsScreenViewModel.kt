package com.shubham.igiaccounts.sale.saledetailsscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.shubham.igiaccounts.database.sale.SaleDatabaseDao

class SaleDetailsScreenViewModel(
    val database: SaleDatabaseDao,
    application: Application
) : AndroidViewModel(application)