package com.example.compui.counter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    //StateFlow - holds current UI state
    private val _uiState = MutableStateFlow(UiState())
    val uiState = _uiState.asStateFlow()

    //SharedFlow - One-Time events
    private val _events = MutableSharedFlow<UiEvent>()
    val event = _events.asSharedFlow()


    fun increment(){

        //update state synchronously
        _uiState.value = _uiState.value.copy(count = _uiState.value.count+1)

        //emit a one-shot event
        viewModelScope.launch {
            _events.emit(UiEvent.ShowToast("Count is ${_uiState.value.count}"))
        }

    }


    fun simulateNetworkAndNavigate(){
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(loading = true)
            //simulate work
            delay(1000)
            _uiState.value = _uiState.value.copy(loading = false)
            _events.emit(UiEvent.NavigateNext)
        }
    }



}

