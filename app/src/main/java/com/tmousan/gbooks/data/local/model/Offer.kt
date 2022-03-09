package com.tmousan.gbooks.data.local.model

import java.io.Serializable

data class Offer(
    val finskyOfferType: Int,
    val listPrice: ListPriceX,
    val retailPrice: RetailPrice
): Serializable