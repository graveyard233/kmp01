package org.lyd.kmp01.expect

import io.ktor.client.HttpClient
import io.ktor.client.engine.js.Js
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

actual fun getHttpClient(json: Json): HttpClient {
    return HttpClient(Js) {
        install(ContentNegotiation){
            json(json)
        }
//        install(Logging) {
//            level = LogLevel.INFO
//        }
    }
}