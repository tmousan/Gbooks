package com.tmousan.gbooks.presenter.books

import com.tmousan.gbooks.data.local.model.BooksResponse

import com.tmousan.gbooks.presenter.ViewHome

//class BooksPresenter(
//    val view: ViewHome.View,
//    private val dataSource: BooksDataSource
//) : BooksHome.Presenter {
//    override fun requestAll() {
//        this.view.showProgressBar()
//        this.dataSource.getBooks(this)
//    }
//
//    override fun onSuccess(booksResponse: BooksResponse) {
//        this.view.showBooks(booksResponse.items)
//    }
//
//    override fun onError(message: String) {
//        this.view.showFailure(message)
//    }
//
//    override fun onComplete() {
//        this.view.hideProgressBar()
//    }
//}