package org.lyd.kmp01.bean
import kotlinx.serialization.Serializable


@Serializable
data class ApiResponse<T>(
    val data: T,
    val errorCode: Int,
    val errorMsg: String
)

@Serializable
data class Article(
    val id: Int,
    val title: String,
    val author: String,
    val niceDate: String,
    val superChapterName: String,
    val chapterName: String,
    val link: String
)

@Serializable
data class ArticleList(
    val curPage: Int,
    val datas: List<Article>,
    val offset: Int,
    val over: Boolean,
    val pageCount: Int,
    val size: Int,
    val total: Int
)
