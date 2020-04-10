package com.shubham.igiaccounts


import android.os.Build
import android.text.Html
import android.text.Spanned
import androidx.core.text.HtmlCompat
import com.shubham.igiaccounts.database.billitemstemp.BillItemsTemp

import com.shubham.igiaccounts.database.customer.Customer
import com.shubham.igiaccounts.database.stock.Stock
import com.shubham.igiaccounts.database.transaction.Transaction

fun formatCustomerList(customers: List<Customer>): Spanned {
    val sb = StringBuilder()
    sb.apply {
        append("<H1>Customer List</H1>")
        customers.forEach {
            append("<br>")
            append("<b>CustomerID: </b>")
            append("\t${it.customerId}<br>")
            append("<b>Name: </b>")
            append("\t${it.customerName}<br>")
            append("<b>Phone: </b>")
            append("\t${it.customerPhone}<br>")
            append("<b>Add: </b>")
            append("\t${it.customerAddress}<br>")
            append("<b>OpeningBal: </b>")
            append("\t${it.customerOpeningBalance}<br>")
            append("<b>CurrentBal: </b>")
            append("\t${it.customerCurrentBalance}<br><br>")

        }
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    } else {
        return HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}

fun formatStockList(stocks: List<Stock>): Spanned {
    val sb = StringBuilder()
    sb.apply {
        append("<H1>Stock List</H1>")
        stocks.forEach {
            append("<br>")
            append("<b>StockID: </b>")
            append("\t${it.stockId}<br>")
            append("<b>Name: </b>")
            append("\t${it.stockName}<br>")
            append("<b>Phone: </b>")
            append("\t${it.stockCategoryName}<br>")
            append("<b>Add: </b>")
            append("\t${it.stockRate}<br>")
            append("<b>OpeningBal: </b>")
            append("\t${it.stockPercentage}<br>")
        }
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    } else {
        return HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}

fun formatItemstemplist(itemstemp: List<BillItemsTemp>): Spanned {
    val sb = StringBuilder()
    sb.apply {
        append("<H1>Items:</H1>")
        itemstemp.forEach {
            append("<br>")
            append("<b>ItemTempID: </b>")
            append("\t${it.billitemstempId}<br>")
            append("<b>ItemId: </b>")
            append("\t${it.billitemstempitemId}<br>")
            append("<b>CustomerId: </b>")
            append("\t${it.billitemstempCustomerID}<br>")
            append("<b>Quantity: </b>")
            append("\t${it.billitemstempQuantity}<br>")
            append("<b>Rate: </b>")
            append("\t${it.billitemstempRate}<br>")
            append("<b>Percentage: </b>")
            append("\t${it.billitemstempPercentage}<br>")
            append("<b>Total: </b>")
            append("\t${it.billitemstempTotal}<br>")
        }
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    } else {
        return HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}

fun formatTransactionList(customers: List<Transaction>): Spanned {
    val sb = StringBuilder()
    sb.apply {
        append("<H1>Transaction List</H1>")
        customers.forEach {
            append("<br>")
            append("<b>TransactionID: </b>")
            append("\t${it.transactionId}<br>")
            append("<b>CustomerId: </b>")
            append("\t${it.transactionCustomerId}<br>")
            append("<b>Amount: </b>")
            append("\t${it.transactionAmount}<br>")
            append("<b>Date: </b>")
            append("\t${it.transactionDate}<br>")
            append("<b>Details: </b>")
            append("\t${it.transactionDetail}<br>")
        }
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    } else {
        return HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}