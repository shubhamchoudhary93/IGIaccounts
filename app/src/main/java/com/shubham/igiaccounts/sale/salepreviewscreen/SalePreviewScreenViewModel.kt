package com.shubham.igiaccounts.sale.salepreviewscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.shubham.igiaccounts.database.sale.SaleDatabaseDao

class SalePreviewScreenViewModel(
    val database: SaleDatabaseDao,
    application: Application
) : AndroidViewModel(application)