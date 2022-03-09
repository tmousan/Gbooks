package com.tmousan.gbooks.repository

import androidx.lifecycle.LiveData
import com.tmousan.gbooks.data.local.db.BookDatabase
import com.tmousan.gbooks.data.local.model.Item
import com.tmousan.gbooks.data.local.model.VolumeInfo
import com.tmousan.gbooks.data.remote.BooksAPI

class BooksRepository (
    private val api: BooksAPI,
    private val db: BookDatabase){

    //Remote
    suspend fun getAllRemote() = api.getBooks()
    suspend fun search(query: String) = api.searchBooks(query)

    //Local
    suspend fun updateInsert(book: Item) = db.getBookDao().updateInsertItem(book)
    fun getAll(): LiveData<MutableList<Item>> = db.getBookDao().getAllItem()
    suspend fun delete(book: Item) = db.getBookDao().deleteItem(book)
}