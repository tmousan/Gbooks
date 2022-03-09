package com.tmousan.gbooks.data.local.model

import java.io.Serializable

data class RetailPrice(
    val amountInMicros: Int,
    val currencyCode: String
): Serializable