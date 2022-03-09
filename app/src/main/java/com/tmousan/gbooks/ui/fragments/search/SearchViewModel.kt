package com.tmousan.gbooks.ui.fragments.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tmousan.gbooks.data.local.model.BooksResponse
import com.tmousan.gbooks.repository.BooksRepository
import com.tmousan.gbooks.util.state.StateResource
import kotlinx.coroutines.launch
import retrofit2.Response

class SearchViewModel constructor(
    private val repository: BooksRepository
): ViewModel() {

    private val _search = MutableLiveData<StateResource<BooksResponse>>()
    val search: LiveData<StateResource<BooksResponse>> get() = _search

    fun fetchSearch(query: String) = viewModelScope.launch {
        safeFetchSearch(query)
    }

    private suspend fun safeFetchSearch(query: String) {
        _search.value = StateResource.Loading()
        try {
            val response = repository.search(query = query)
            _search.value = handleResponse(response)
        } catch (e: Exception) {
            _search.value = StateResource.Error("Dados não encontrados: ${e.message}")
        }
    }

    private fun handleResponse(response: Response<BooksResponse>): StateResource<BooksResponse>? {
        if (response.isSuccessful) {
            response.body()?.let { values ->
                return StateResource.Success(values)
            }
        }
        return StateResource.Error(response.message())
    }
}