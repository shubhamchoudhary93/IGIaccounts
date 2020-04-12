package com.shubham.igiaccounts.sale.salepreviewscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.shubham.igiaccounts.database.sale.Sale
import com.shubham.igiaccounts.database.sale.SaleDatabaseDao
import kotlinx.coroutines.*

class SalePreviewScreenViewModel(
    val database: SaleDatabaseDao,
    application: Application
) : AndroidViewModel(application) {

    var liveC = MutableLiveData<Boolean>()
    var sale = Sale()

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    init {
        liveC.value = false
    }

    fun fetchCustomer(saleId: Long) {
        uiScope.launch {

            withContext(Dispatchers.IO) {
                sale = if (saleId == 0L) {
                    try {
                        database.getLastSale()
                    } catch (e: Exception) {
                        e.printStackTrace()
                        Sale()
                    }
                } else {
                    try {
                        database.get(saleId)!!
                    } catch (e: Exception) {
                        e.printStackTrace()
                        Sale()
                    }
                }

            }
            liveC.value = true
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}