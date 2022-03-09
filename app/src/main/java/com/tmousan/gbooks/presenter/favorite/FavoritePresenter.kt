package com.tmousan.gbooks.presenter.favorite

import com.tmousan.gbooks.data.local.model.VolumeInfo

import com.tmousan.gbooks.presenter.ViewHome

//class FavoritePresenter(val view: ViewHome.Favorite,
//                        private val dataSource: BooksDataSource
//): FavoriteHome.Presenter {
//
//    fun getAll(){
//        this.dataSource.getAllBooks(this)
//    }
//
//    fun deleteBook(book: VolumeInfo){
//        this.dataSource.deleteBooks(book)
//    }
//
//    fun saveBook(book: VolumeInfo){
//        this.dataSource.saveBook(book)
//    }
//
//    override fun onSuccess(books: MutableList<VolumeInfo>) {
//        this.view.showBooks(books)
//    }
//}