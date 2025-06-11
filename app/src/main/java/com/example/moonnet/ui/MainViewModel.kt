package com.example.moonnet.ui

import androidx.lifecycle.*
import com.example.moonnet.data.ZenRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val repo = ZenRepository()

    private val _zen = MutableLiveData<String>()
    val zen: LiveData<String> = _zen

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    fun loadZen() {
        viewModelScope.launch(Dispatchers.IO) {
            repo.fetchZen()
                .onSuccess { quote ->
                    _zen.postValue(quote)
                    _error.postValue(null)
                }
                .onFailure { ex ->
                    _error.postValue(ex.localizedMessage)
                }
        }
    }
}
