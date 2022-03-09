package com.tmousan.gbooks.data.local.model

import java.io.Serializable

data class SaleInfo(
    val buyLink: String?,
    val country: String,
    val isEbook: Boolean,
    val listPrice: ListPrice,
    val offers: List<Offer>,
    val retailPrice: RetailPriceX,
    val saleability: String
): Serializable