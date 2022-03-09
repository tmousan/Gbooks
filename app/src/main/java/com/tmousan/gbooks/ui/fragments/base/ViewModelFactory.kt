package com.tmousan.gbooks.ui.fragments.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tmousan.gbooks.data.remote.BooksAPI
import com.tmousan.gbooks.repository.BooksRepository
import com.tmousan.gbooks.ui.fragments.book.BookViewModel
import com.tmousan.gbooks.ui.fragments.favorite.FavoriteViewModel
import com.tmousan.gbooks.ui.fragments.home.HomeViewModel
import com.tmousan.gbooks.ui.fragments.search.SearchViewModel

class ViewModelFactory(
    private val repository: BooksRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> HomeViewModel(repository) as T
            modelClass.isAssignableFrom(SearchViewModel::class.java) -> SearchViewModel(repository) as T
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> FavoriteViewModel(repository) as T
            modelClass.isAssignableFrom(BookViewModel::class.java) -> BookViewModel(repository) as T
            else -> throw IllegalArgumentException("ViewModel não encontrado")
        }
    }
}