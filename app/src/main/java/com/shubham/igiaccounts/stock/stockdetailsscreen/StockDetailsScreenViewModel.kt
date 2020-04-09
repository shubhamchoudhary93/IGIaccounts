package com.shubham.igiaccounts.stock.stockdetailsscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.shubham.igiaccounts.database.stock.Stock
import com.shubham.igiaccounts.database.stock.StockDatabaseDao
import kotlinx.coroutines.*

class StockDetailsScreenViewModel(
    val database: StockDatabaseDao,
    application: Application
) : AndroidViewModel(application) {
    var liveC = MutableLiveData<Boolean>()
    var stock = Stock()

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    init {
        liveC.value = false
    }

    fun fetchStock(stockId: Long) {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                stock = if (stockId == 0L) {
                    try {
                        database.getLastStock()
                    } catch (e: Exception) {
                        e.printStackTrace()
                        Stock()
                    }
                } else {
                    try {
                        database.get(stockId)!!
                    } catch (e: Exception) {
                        e.printStackTrace()
                        Stock()
                    }
                }

            }
            liveC.value = true
        }
    }

    fun deleteStock(stockId: Long) {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    database.delete(stockId)
                } catch (e: Exception) {
                    e.printStackTrace()

                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}