package co.pvitor.cryptocoinapp.util

import java.text.NumberFormat
import java.util.*

@Suppress("UNCHECKED_CAST")
fun <T> Any.findClassPropertyValue(propertyName: String) : T {

    val propertyValue = this::class.members.firstOrNull {
        it.name == propertyName
    }?.call(this)

    return propertyValue as T ?: throw ClassCastException()
}

fun Any.formatCurrency(currencyISO: String, fractionDigits: Int = 2) : String {

    val format = NumberFormat.getCurrencyInstance()
    format.maximumFractionDigits = fractionDigits
    format.currency = Currency.getInstance(currencyISO.uppercase())

    return format.format(this)
}

