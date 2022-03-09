package com.tmousan.gbooks.data.local.model

import java.io.Serializable

data class BooksResponse(
    val items: MutableList<Item>,
    val kind: String,
    val totalItems: Int
): Serializable