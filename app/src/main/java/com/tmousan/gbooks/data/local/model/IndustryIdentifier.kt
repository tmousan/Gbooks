package com.tmousan.gbooks.data.local.model

import java.io.Serializable

data class IndustryIdentifier(
    val identifier: String,
    val type: String
): Serializable