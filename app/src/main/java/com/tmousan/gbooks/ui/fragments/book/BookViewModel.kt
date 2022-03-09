package com.tmousan.gbooks.ui.fragments.book

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tmousan.gbooks.data.local.model.Item
import com.tmousan.gbooks.data.local.model.VolumeInfo
import com.tmousan.gbooks.repository.BooksRepository
import kotlinx.coroutines.launch

class BookViewModel constructor(
    private val repository: BooksRepository
) : ViewModel() {

    fun saveBook(book: Item) = viewModelScope.launch {
        repository.updateInsert(book)
    }
}