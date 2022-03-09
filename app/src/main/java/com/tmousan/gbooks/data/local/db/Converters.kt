package com.tmousan.gbooks.data.local.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tmousan.gbooks.data.local.model.ImageLinks
import com.tmousan.gbooks.data.local.model.VolumeInfo

class Converters {

    @TypeConverter
    fun fromImage (imageLinks: ImageLinks): String{
        return imageLinks.smallThumbnail.toString()
    }

    @TypeConverter
    fun toImage (name: String): ImageLinks {
        return ImageLinks(name, name)
    }

    @TypeConverter
    fun fromItem(volumeInfo:  VolumeInfo): String? {
        return volumeInfo.title.toString()
    }

    @TypeConverter
    fun toItem(title: String) : VolumeInfo {
        return VolumeInfo(null, null, null, title )
    }

//    @TypeConverter
//    fun fromString(volumeInfo: String): VolumeInfo {
//        val list = object : TypeToken<VolumeInfo>() {}.type
//        return Gson().fromJson(volumeInfo, list)
//    }
//
//    @TypeConverter
//    fun fromListLisr(volumeInfo: VolumeInfo): String {
//        val gson = Gson()
//        return gson.toJson(volumeInfo)
//    }
    @TypeConverter
    fun toListOfStrings(authors: String): List<String> {
        return authors.split(",")
    }
    @TypeConverter
    fun fromListOfStrings(authors: MutableList<String>): String {
        return authors.joinToString(",")
    }



}