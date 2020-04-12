package com.shubham.igiaccounts


import android.text.Html
import android.text.Spanned
import com.shubham.igiaccounts.database.customer.Customer
import com.shubham.igiaccounts.database.saledetails.SaleDetails
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
    return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
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
    return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
}

fun formatItemslist(itemsTemp: List<SaleDetails>): Spanned {
    val sb = StringBuilder()
    sb.apply {
        append("<H1>Items:</H1>")
        itemsTemp.forEach {
            append("<br>")
            append("<b>SaleDetailsID: </b>")
            append("\t${it.saleDetailsId}<br>")
            append("<b>SaleID: </b>")
            append("\t${it.saleDetailsSaleId}<br>")
            append("<b>Item: </b>")
            append("\t${it.saleDetailsItem}<br>")
            append("<b>Customer: </b>")
            append("\t${it.saleDetailsCustomer}<br>")
            append("<b>Quantity: </b>")
            append("\t${it.saleDetailsQuantity}<br>")
            append("<b>Rate: </b>")
            append("\t${it.saleDetailsRate}<br>")
            append("<b>Percentage: </b>")
            append("\t${it.saleDetailsPercentage}<br>")
            append("<b>Total: </b>")
            append("\t${it.saleDetailsTotal}<br>")
        }
    }
    return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
}

fun formatTransactionList(customers: List<Transaction>): Spanned {
    val sb = StringBuilder()
    sb.apply {
        append("<H1>Transaction List</H1>")
        customers.forEach {
            append("<br>")
            append("<b>TransactionID: </b>")
            append("\t${it.transactionId}<br>")
            append("<b>Customer: </b>")
            append("\t${it.transactionCustomer}<br>")
            append("<b>Amount: </b>")
            append("\t${it.transactionAmount}<br>")
            append("<b>Date: </b>")
            append("\t${it.transactionDate}<br>")
            append("<b>Details: </b>")
            append("\t${it.transactionDetail}<br>")
        }
    }
    return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
}