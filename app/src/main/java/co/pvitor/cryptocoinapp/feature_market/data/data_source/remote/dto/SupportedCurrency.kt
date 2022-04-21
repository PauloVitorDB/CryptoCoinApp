package co.pvitor.cryptocoinapp.feature_market.data.data_source.remote.dto

import java.text.NumberFormat
import java.util.*

data class SupportedCurrency(
    val aed: Double,
    val ars: Double,
    val aud: Double,
    val bch: Double,
    val bdt: Double,
    val bhd: Double,
    val bits: Double,
    val bmd: Double,
    val bnb: Double,
    val brl: Double,
    val btc: Double,
    val cad: Double,
    val chf: Double,
    val clp: Double,
    val cny: Double,
    val czk: Double,
    val dkk: Double,
    val dot: Double,
    val eos: Double,
    val eth: Double,
    val eur: Double,
    val gbp: Double,
    val hkd: Double,
    val huf: Double,
    val idr: Double,
    val ils: Double,
    val inr: Double,
    val jpy: Double,
    val krw: Double,
    val kwd: Double,
    val link: Double,
    val lkr: Double,
    val ltc: Double,
    val mmk: Double,
    val mxn: Double,
    val myr: Double,
    val ngn: Double,
    val nok: Double,
    val nzd: Double,
    val php: Double,
    val pkr: Double,
    val pln: Double,
    val rub: Double,
    val sar: Double,
    val sats: Double,
    val sek: Double,
    val sgd: Double,
    val thb: Double,
    val `try`: Double,
    val twd: Double,
    val uah: Double,
    val usd: Double,
    val vef: Double,
    val vnd: Double,
    val xag: Double,
    val xau: Double,
    val xdr: Double,
    val xlm: Double,
    val xrp: Double,
    val yfi: Double,
    val zar: Double
)

fun SupportedCurrency.formatCurrency(currencyISO: String, value: Double, fractionDigits: Int = 2) : String  {

    val format = NumberFormat.getCurrencyInstance()
    format.currency = Currency.getInstance(currencyISO.uppercase())
    format.maximumFractionDigits = fractionDigits

    return format.format(value)
}