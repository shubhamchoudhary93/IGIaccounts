package com.shubham.igiaccounts.transaction.transactionlistscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.shubham.igiaccounts.database.transaction.TransactionDatabaseDao

class TransactionListScreenViewModel(
    val database: TransactionDatabaseDao,
    application: Application
) : AndroidViewModel(application)