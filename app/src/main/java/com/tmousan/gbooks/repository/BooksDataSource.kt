package com.tmousan.gbooks.repository

import android.content.Context
import com.tmousan.gbooks.data.local.db.BookDatabase
import com.tmousan.gbooks.data.local.model.Item
import com.tmousan.gbooks.data.local.model.VolumeInfo
import com.tmousan.gbooks.data.remote.RetrofitInstance
import com.tmousan.gbooks.data.remote.RetrofitInstance.Companion.api
import com.tmousan.gbooks.presenter.books.BooksHome
import com.tmousan.gbooks.presenter.favorite.FavoriteHome
import com.tmousan.gbooks.presenter.search.SearchHome
import kotlinx.coroutines.*

//class BooksDataSource (context: Context) {
//
//    private var db: BookDatabase = BookDatabase(context)
//    private var booksRepository: BooksRepository = BooksRepository(api,db)
//    fun getBooks(callback: BooksHome.Presenter){
//        CoroutineScope(Dispatchers.Main).launch {
//            val response = RetrofitInstance.api.getBooks()
//            if (response.isSuccessful){
//                response.body()?.let { booksResponse ->
//                    callback.onSuccess(booksResponse)
//                }
//                callback.onComplete()
//            } else {
//                callback.onError(response.message())
//                callback.onComplete()
//            }
//        }
//    }
//
//    fun searchBooks(term: String, callback: SearchHome.Presenter){
//        CoroutineScope(Dispatchers.Main).launch {
//            val response = RetrofitInstance.api.searchBooks(term)
//            if (response.isSuccessful){
//                response.body()?.let { booksResponse ->
//                    callback.onSuccess(booksResponse)
//                }
//                callback.onComplete()
//            } else {
//                callback.onError(response.message())
//                callback.onComplete()
//            }
//        }
//    }
//
//    fun saveBook(book: Item){
//        CoroutineScope(Dispatchers.Main).launch {
//            booksRepository.updateInsert(book)
//        }
//    }
//
//    fun getAllBooks(callback: FavoriteHome.Presenter){
//        var allBooks: MutableList<Item>
//        CoroutineScope(Dispatchers.IO).launch{
//            allBooks = booksRepository.getAll().value!!
//
//            withContext(Dispatchers.Main){
//                callback.onSuccess(allBooks)
//            }
//        }
//    }
//
//    fun deleteBooks(book: Item?){
//        CoroutineScope(Dispatchers.Main).launch {
//            book?.let { bookSafe ->
//                booksRepository.delete(bookSafe)
//            }
//        }
//    }
//}