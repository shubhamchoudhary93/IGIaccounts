package com.shubham.igiaccounts.sale.saleitemmodifyscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.shubham.igiaccounts.database.sale.SaleDatabaseDao

class SaleItemModifyScreenViewModel(
    val database: SaleDatabaseDao,
    application: Application
) : AndroidViewModel(application)