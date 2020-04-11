package com.shubham.igiaccounts.sale.salenewscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.shubham.igiaccounts.database.sale.SaleDatabaseDao
import com.shubham.igiaccounts.database.saleitemstemp.SaleItemsTemp
import com.shubham.igiaccounts.database.saleitemstemp.SaleItemsTempDatabase
import com.shubham.igiaccounts.formatItemsTemplist
import kotlinx.coroutines.*

class SaleNewScreenViewModel(
    val database: SaleDatabaseDao,
    application: Application
) : AndroidViewModel(application) {

    var liveC = MutableLiveData<Int>()


    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private val databaseSaleTemp =
        SaleItemsTempDatabase.getInstance(application).saleItemsTempDatabaseDao
    var itemsTempList = databaseSaleTemp.getAllItems()
    val tempItemsString =
        Transformations.map(itemsTempList) { itemsTempList -> formatItemsTemplist(itemsTempList) }
    var total = 0F
    private var noOfItems = 0

    init {
        liveC.value = 0
    }

    fun addNewItemTemp(
        name: String,
        customerName: String,
        quantity: Float,
        rate: Float,
        percentage: Float,
        transport: Float,
        otherCharges: Float
    ) {
        noOfItems.plus(1)
//        if (quantity == null) quantity = 0.0F
        saleTempInsert(
            saleItemTemp = SaleItemsTemp(
                0,
                name,
                customerName,
                quantity,
                rate,
                percentage,
                quantity * rate * percentage
            )
        )
        fetchItemsTempList(transport, otherCharges)

    }

    private fun saleTempInsert(saleItemTemp: SaleItemsTemp) {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                databaseSaleTemp.insert(
                    saleItemTemp
                )
            }
        }
    }

    private fun fetchItemsTempList(
        transport: Float,
        otherCharges: Float
    ) {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                itemsTempList = databaseSaleTemp.getAllItems()

                val totalAll = databaseSaleTemp.gettotals()
                totalAll.forEach { total -> total.plus(total) }
                for (total1 in totalAll) {
                    total += total1
                }
                total += transport
                total += otherCharges
            }

        }
        liveC.value = liveC.value?.plus(1)
    }
}