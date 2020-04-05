package com.shubham.igiaccounts.transaction.transactionnewscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.shubham.igiaccounts.database.transaction.TransactionDatabaseDao

class TransactionNewScreenViewModel(
    val database: TransactionDatabaseDao,
    application: Application
) : AndroidViewModel(application)