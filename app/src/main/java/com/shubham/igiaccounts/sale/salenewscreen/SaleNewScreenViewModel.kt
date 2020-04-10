package com.shubham.igiaccounts.sale.salenewscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.shubham.igiaccounts.database.billitemstemp.BillItemsTemp
import com.shubham.igiaccounts.database.billitemstemp.BillItemsTempDatabase
import com.shubham.igiaccounts.database.customer.CustomerDatabase
import com.shubham.igiaccounts.database.sale.SaleDatabaseDao
import com.shubham.igiaccounts.database.stock.StockDatabase
import com.shubham.igiaccounts.formatItemstemplist
import kotlinx.coroutines.*

class SaleNewScreenViewModel(
    val database: SaleDatabaseDao,
    application: Application
) : AndroidViewModel(application) {

    var liveC = MutableLiveData<Int>()


    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    val databasecustomer = CustomerDatabase.getInstance(application).customerDatabaseDao
    val databasebilltemp = BillItemsTempDatabase.getInstance(application).billItemsTempDatabaseDao
    val databasestock = StockDatabase.getInstance(application).stockDatabaseDao
    var itemstemplist = databasebilltemp.getAllItems()
    val tempitemsString =
        Transformations.map(itemstemplist) { itemstemplist -> formatItemstemplist(itemstemplist) }
    var itemid = 0L
    var customerid = 0L
    var total = 0F
    private var noOfItems = MutableLiveData<Int>()

    init {
        liveC.value = 0
        noOfItems.value = 0
    }

    fun addNewItemTemp(
        name: String,
        customername: String,
        quantity: Float,
        rate: Float,
        percentage: Float
    ) {
        noOfItems.value?.plus(1)
        fetchitemId(name)
        fetchcustomerId(customername)
        billtempinsert(
            billitemtemp = BillItemsTemp(
                0,
                itemid,
                customerid,
                quantity,
                rate,
                percentage,
                quantity * rate * percentage
            )
        )
        fetchitemstemplist()

    }

    fun billtempinsert(billitemtemp: BillItemsTemp) {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                databasebilltemp.insert(
                    billitemtemp
                )
            }
        }
    }

    fun fetchitemId(name: String) {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                itemid = databasestock.searchStockID(name)

            }
        }
    }

    fun fetchcustomerId(name: String) {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                customerid = databasecustomer.searchCustomerID(name)
            }
        }
    }

    fun fetchitemstemplist() {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                itemstemplist = databasebilltemp.getAllItems()

                val totalall = databasebilltemp.gettotals()
                totalall.forEach { total = total.plus(total) }
            }

        }
        liveC.value = liveC.value?.plus(1)
    }
}