package com.example.compui.counter


data class UiState (
    val count: Int = 0,
    val loading: Boolean = false
)


sealed interface UiEvent {
    data class ShowToast(val message:String): UiEvent
    object NavigateNext: UiEvent
}



