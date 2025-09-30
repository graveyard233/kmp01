package org.lyd.kmp01.network.networkData

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.koin.core.component.KoinComponent
import org.lyd.kmp01.bean.ApiResponse
import org.lyd.kmp01.bean.Article
import org.lyd.kmp01.bean.ArticleList
import org.lyd.kmp01.network.WanAndroidNetworkData

internal class WanAndroidNetData(private val client: HttpClient): KoinComponent, WanAndroidNetworkData {
    val baseUrl = "https://www.wanandroid.com"

    override suspend fun getArticleList(page: Int): ApiResponse<ArticleList> = client.get(
        "$baseUrl/article/list/$page/json"
    ).body<ApiResponse<ArticleList>>()
}