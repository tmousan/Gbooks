package com.tmousan.gbooks.presenter.books

import com.tmousan.gbooks.data.local.model.BooksResponse

interface BooksHome {

    interface Presenter{
        fun requestAll()
        fun onSuccess(booksResponse: BooksResponse)
        fun onError(message: String)
        fun onComplete()
    }
}