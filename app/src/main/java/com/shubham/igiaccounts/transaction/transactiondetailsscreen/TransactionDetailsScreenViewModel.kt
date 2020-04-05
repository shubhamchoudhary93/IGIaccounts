package com.shubham.igiaccounts.transaction.transactiondetailsscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.shubham.igiaccounts.database.transaction.TransactionDatabaseDao

class TransactionDetailsScreenViewModel(
    val database: TransactionDatabaseDao,
    application: Application
) : AndroidViewModel(application)