package com.tmousan.gbooks.data.local.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "testbook")
data class Item(

    @PrimaryKey(autoGenerate = true)
    val cont: Int? = null,

    val etag: String?,
    val id: String?,
    val kind: String?,
    val selfLink: String?,
    val volumeInfo: VolumeInfo?
): Serializable