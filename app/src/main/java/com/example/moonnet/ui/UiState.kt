package com.example.moonnet.ui

sealed class UiState {
    object Loading        : UiState()
    data class Success(val quote: String) : UiState()
    data class Error  (val message: String) : UiState()
}
