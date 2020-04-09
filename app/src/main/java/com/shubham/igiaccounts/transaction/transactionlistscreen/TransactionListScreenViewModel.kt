package com.shubham.igiaccounts.transaction.transactionlistscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Transformations
import com.shubham.igiaccounts.database.transaction.TransactionDatabaseDao
import com.shubham.igiaccounts.formatTransactionList

class TransactionListScreenViewModel(
    val database: TransactionDatabaseDao,
    application: Application
) : AndroidViewModel(application) {
    private var transactions = database.getAllTransactions()

    val transactionsString =
        Transformations.map(transactions) { transactions -> formatTransactionList(transactions) }
}