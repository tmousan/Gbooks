package com.tmousan.gbooks.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "testbook")
data class VolumeInfo(

    val authors: MutableList<String>?,
    val description: String?,
    val imageLinks: ImageLinks?,
    val title: String?
): Serializable