package com.tmousan.gbooks.data.local.model

import java.io.Serializable

data class Pdf(
    val acsTokenLink: String,
    val isAvailable: Boolean
): Serializable