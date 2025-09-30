package org.lyd.kmp01.network.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import org.lyd.kmp01.bean.ApiResponse
import org.lyd.kmp01.bean.ArticleList
import org.lyd.kmp01.bean.Result
import org.lyd.kmp01.network.WanAndroidNetworkData

class WanAndroidRepository(
    private val wanAndroidNetworkData: WanAndroidNetworkData
) {

    fun getArticleList(page: Int): Flow<Result<ArticleList>> =
        standardRequest {
            wanAndroidNetworkData.getArticleList(page)
        }

    private fun <T> standardRequest(
        request: suspend () -> ApiResponse<T>
    ): Flow<Result<T>> = flow {
        val response = request()
        if (response.errorCode == 0){
            emit(Result.Success(data = response.data))
        } else {
            emit(Result.Error(error = response.errorMsg))
        }
    }
        .onStart { emit(Result.Loading) }
        .catch {
            emit(Result.Error(error = it.message.toString()))
            println("error when request: ${it.message} ${it.stackTraceToString()}")
        }
        .flowOn(Dispatchers.Default)
}