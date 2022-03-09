package com.tmousan.gbooks.data.local.model

import java.io.Serializable

data class PanelizationSummary(
    val containsEpubBubbles: Boolean,
    val containsImageBubbles: Boolean
): Serializable