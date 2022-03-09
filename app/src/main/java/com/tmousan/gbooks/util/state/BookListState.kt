package com.tmousan.gbooks.util.state

import com.tmousan.gbooks.data.local.model.Item
import com.tmousan.gbooks.data.local.model.VolumeInfo

sealed class BookListState {
    data class Success(val list: MutableList<Item>) : BookListState()
    data class ErrorMessage(val errorMessage: String) : BookListState()
    object Loading : BookListState()
    object Empty : BookListState()
}