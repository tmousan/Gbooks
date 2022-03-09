package com.tmousan.gbooks.ui.fragments.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tmousan.gbooks.data.local.model.BooksResponse
import com.tmousan.gbooks.repository.BooksRepository
import com.tmousan.gbooks.util.state.StateResource
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel (private val repository: BooksRepository) : ViewModel() {

    private val _getAll = MutableLiveData<StateResource<BooksResponse>>()
    val getAll: LiveData<StateResource<BooksResponse>> get() = _getAll

    init {
        safeFetchAll()
    }

    private fun safeFetchAll() = viewModelScope.launch {
        _getAll.value = StateResource.Loading()
        try {
            val response = repository.getAllRemote()
            _getAll.value = handleResponse(response)
        } catch (e: Exception) {
            _getAll.value = StateResource.Error("Dados não encontrados: ${e.message}")
        }
    }

    private fun handleResponse(response: Response<BooksResponse>): StateResource<BooksResponse> {
        if (response.isSuccessful) {
            response.body()?.let { values ->
                return StateResource.Success(values)
            }
        }
        return StateResource.Error(response.message())
    }


}