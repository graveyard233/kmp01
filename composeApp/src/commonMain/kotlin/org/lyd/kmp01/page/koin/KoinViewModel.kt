package org.lyd.kmp01.page.koin

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class KoinViewModel(
    private val savedStateHandle: SavedStateHandle
): ViewModel(){
    private val _numFlow = MutableStateFlow(0)
    val numFlow = _numFlow.asStateFlow()

    fun addNum(){
        _numFlow.value += 1
    }
    fun subNum(){
        _numFlow.value -= 1
    }
}