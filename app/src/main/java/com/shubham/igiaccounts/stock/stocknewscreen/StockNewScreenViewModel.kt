package com.shubham.igiaccounts.stock.stocknewscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.shubham.igiaccounts.database.stock.Stock
import com.shubham.igiaccounts.database.stock.StockDatabaseDao
import kotlinx.coroutines.*

class StockNewScreenViewModel(
    val database: StockDatabaseDao,
    application: Application
) : AndroidViewModel(application) {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun insertStock(name: String, category: String, rate: Float, percentage: Float) {
        uiScope.launch {
            val stock = Stock()
            stock.stockName = name
            stock.stockCategoryName = category
            stock.stockPercentage = percentage
            stock.stockRate = rate
            insert(stock)
        }
    }

    private suspend fun insert(stock: Stock) {
        withContext(Dispatchers.IO) {
            database.insert(stock)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}