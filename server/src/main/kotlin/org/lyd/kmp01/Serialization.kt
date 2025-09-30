package org.lyd.kmp01

import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import org.lyd.kmp01.bean.Article

fun Application.configureSerialization() {
    install(ContentNegotiation){
        json(json = json)
    }
    routing {
        get("/json"){
            call.respond(mapOf("message" to "Hello World! Json"))
        }
        get("/article") {
            val article = Article(
                id = 1,
                title = "Ktor",
                author = "lyd",
                niceDate = "2022-01-01",
                superChapterName = "Ktor",
                chapterName = "Ktor",
                link = "https://github.com/"
            )
            call.respond(article)
        }
        get("/num") {
            val token = call.request.queryParameters["token"]
            if (token != null){
                call.respond(mapOf("token" to token))
            } else {
                call.respond(HttpStatusCode.BadRequest, "token is null")
            }
        }
    }
}