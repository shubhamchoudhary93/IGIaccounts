package com.shubham.igiaccounts.transaction.transactionmodifyscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.shubham.igiaccounts.database.transaction.TransactionDatabaseDao

class TransactionModifyScreenViewModel(
    val database: TransactionDatabaseDao,
    application: Application
) : AndroidViewModel(application)