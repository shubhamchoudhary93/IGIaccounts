package com.shubham.igiaccounts.sale.salenewscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.shubham.igiaccounts.database.sale.Sale
import com.shubham.igiaccounts.database.sale.SaleDatabaseDao
import com.shubham.igiaccounts.database.saledetails.SaleDetails
import com.shubham.igiaccounts.database.saledetails.SaleDetailsDatabase
import com.shubham.igiaccounts.formatItemslist
import kotlinx.coroutines.*

class SaleNewScreenViewModel(
    val database: SaleDatabaseDao,
    application: Application
) : AndroidViewModel(application) {

    var liveC = MutableLiveData<Int>()


    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private val databaseSaleDetails =
        SaleDetailsDatabase.getInstance(application).saleDetailsDatabaseDao
    var itemsList = databaseSaleDetails.getAllSaleDetails()
    var itemsString =
        Transformations.map(itemsList) { itemsList -> formatItemslist(itemsList) }
    var total: Float
    private var noOfItems: Long
    var lastSaleId: Long

    private var saleDetailsIdList = mutableListOf<Long>()

    init {
        liveC.value = 0
        total = 0F
        noOfItems = 0L
        lastSaleId = 0L
    }

    fun addNewItem(
        name: String,
        customerName: String,
        quantity: Float,
        rate: Float,
        percentage: Float,
        transport: Float,
        otherCharges: Float
    ) {
        noOfItems.plus(1)
        saleDetailsInsert(
            saleDetails = SaleDetails(
                0,
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

    private fun saleDetailsInsert(saleDetails: SaleDetails) {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                databaseSaleDetails.insert(
                    saleDetails
                )
                var id = databaseSaleDetails.getLastSaleDetailsID()
                saleDetailsIdList.add(id)
            }
        }
    }

    fun addSale(
        cash: Boolean,
        date: String,
        customerName: String,
        transport: Float,
        otherCharges: Float
    ) {
        saleSaleInsert(
            sale = Sale(
                0,
                cash,
                date,
                customerName,
                noOfItems,
                transport,
                otherCharges,
                total
            )

        )

    }

    private fun saleSaleInsert(sale: Sale) {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                database.insert(
                    sale
                )
                println(sale.saleCash)
                println(sale.saleAmount)
                println(sale.saleNoOfItems)
                lastSaleId = database.getLastSaleID()
                println("funct last sale id : " + lastSaleId)
                saleDetailsIdList.forEach {
                    databaseSaleDetails.updateSaleDetailsId(
                        it,
                        lastSaleId
                    )
                }

            }
        }
    }

    private fun fetchItemsTempList(
        transport: Float,
        otherCharges: Float
    ) {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                itemsList = databaseSaleDetails.getAllSaleDetails()

                val totalAll = databaseSaleDetails.getTotals()
                total = 0F
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