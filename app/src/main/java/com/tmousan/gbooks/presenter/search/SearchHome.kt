package com.tmousan.gbooks.presenter.search

import com.tmousan.gbooks.data.local.model.BooksResponse

interface SearchHome {

    interface Presenter{
        fun search(term: String)
        fun onSuccess(booksResponse: BooksResponse)
        fun onError(message: String)
        fun onComplete()
    }
}