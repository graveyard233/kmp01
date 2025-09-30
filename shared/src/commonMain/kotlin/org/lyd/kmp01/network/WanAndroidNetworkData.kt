package org.lyd.kmp01.network

import org.lyd.kmp01.bean.ApiResponse
import org.lyd.kmp01.bean.ArticleList

interface WanAndroidNetworkData {
    suspend fun getArticleList(page: Int): ApiResponse<ArticleList>
}