package com.tmousan.gbooks.data.local.model

import java.io.Serializable

data class ReadingModes(
    val image: Boolean,
    val text: Boolean
): Serializable