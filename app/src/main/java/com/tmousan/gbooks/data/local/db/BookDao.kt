package com.tmousan.gbooks.data.local.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.tmousan.gbooks.data.local.model.Item
import com.tmousan.gbooks.data.local.model.VolumeInfo

@Dao
interface BookDao {

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun updateInsert (book: VolumeInfo): Long
//
//    @Query("SELECT*FROM book")
//    fun getAll(): LiveData<MutableList<VolumeInfo>>
//
//    @Delete
//    suspend fun delete(book: VolumeInfo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateInsertItem (book: Item): Long

    @Query("SELECT*FROM testbook")
    fun getAllItem(): LiveData<MutableList<Item>>

    @Delete
    suspend fun deleteItem(book: Item)
}