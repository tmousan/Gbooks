package com.tmousan.gbooks.ui.fragments.favorite

import androidx.lifecycle.*
import com.tmousan.gbooks.data.local.model.Item
import com.tmousan.gbooks.data.local.model.VolumeInfo
import com.tmousan.gbooks.repository.BooksRepository
import com.tmousan.gbooks.util.state.BookListEvent
import com.tmousan.gbooks.util.state.BookListState
import kotlinx.coroutines.launch

class FavoriteViewModel constructor(
    private val repository: BooksRepository) : ViewModel() {

    private val _favorite = MutableLiveData<BookListEvent>()
    val favorite: LiveData<BookListState> = _favorite.switchMap {
        when(it){
            BookListEvent.Fetch -> getAllItem()
        }
    }

    fun dispatch(event: BookListEvent){
        this._favorite.postValue(event)
    }

    private fun getAllItem(): LiveData<BookListState> {
        return liveData {
            try {
                emit(BookListState.Loading)
                val listLiveData = repository.getAll()
                    .map { list ->
                        if (list.isEmpty()){
                            BookListState.Empty
                        } else{
                            BookListState.Success(list)
                        }
                    }
                emitSource(listLiveData)
            } catch (e: Exception){
                emit(BookListState.ErrorMessage("Algo deu errado"))
            }
        }
    }

    fun saveBook(book: Item) = viewModelScope.launch {
        repository.updateInsert(book)
    }

    fun deleteBook(book: Item) = viewModelScope.launch {
        repository.delete(book)
    }


}