package org.lyd.kmp01.expect

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.engine.js.Js
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

actual fun getHttpClient(json: Json): HttpClient {
    // 注意：引擎最好不要用CIO，缺node.js的网络库
    // 目前存在跨域问题(CORS)，导致某些网络请求被服务器拒绝
    return HttpClient(Js) {
        install(ContentNegotiation){
            json(json)
        }
//        install(Logging) {
//            level = LogLevel.INFO
//        }
    }
}