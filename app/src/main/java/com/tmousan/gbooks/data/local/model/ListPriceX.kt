package com.tmousan.gbooks.data.local.model

import java.io.Serializable

data class ListPriceX(
    val amountInMicros: Int,
    val currencyCode: String
): Serializable