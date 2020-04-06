package com.shubham.igiaccounts


import android.os.Build
import android.text.Html
import android.text.Spanned
import androidx.core.text.HtmlCompat

import com.shubham.igiaccounts.database.customer.Customer

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