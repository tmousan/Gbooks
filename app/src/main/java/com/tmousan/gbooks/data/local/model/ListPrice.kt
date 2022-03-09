package com.tmousan.gbooks.data.local.model

import java.io.Serializable

data class ListPrice(
    val amount: Double,
    val currencyCode: String
): Serializable