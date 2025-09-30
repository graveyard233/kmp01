package org.lyd.kmp01.page.baseTest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.lyd.kmp01.bean.Result
import org.lyd.kmp01.network.repository.WanAndroidRepository

class BaseTestNetViewModel(
    private val repository: WanAndroidRepository
): ViewModel() {

    private val _resultState = MutableStateFlow("")
    val resultState = _resultState.asStateFlow()

    fun getArticleList(page: Int = 1) {
        viewModelScope.launch {
            repository.getArticleList(page).collectLatest { result ->
                when(result){
                    is Result.Loading -> {
                        _resultState.update { "Loading" }
                    }
                    is Result.Success -> {
                        val dataStr = result.data.datas.joinToString("\n") {
                            it.title
                        }
                        _resultState.update { dataStr }
                    }
                    is Result.Error -> {
                        _resultState.update { result.error }
                    }
                }
            }
        }

    }
}