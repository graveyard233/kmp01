package org.lyd.kmp01

import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.http.content.staticResources
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.response.respondFile
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import org.lyd.kmp01.module.TaskRepository
import org.lyd.kmp01.module.tasksAsTable
import java.io.File

fun Application.configureRouting(){
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = "App error: ${cause.message}" , status = HttpStatusCode.InternalServerError)
        }
    }
    routing {

        get("/") {
            call.respondText("Ktor: ${Greeting().greet()}")
        }
        get("/error") {
            throw IllegalStateException("Too Busy")
        }
        get("/hello") {
//            call.respondText("i say hello.")
//            throw Exception("i say hello error.")
            val file = File("src/main/resources/HelloWorld.html")
            call.respondFile(file = file)
        }
    }
    routing {
        get("/tasks") {
            call.respondText(
                contentType = ContentType.parse("text/html"),
                text = TaskRepository.tasks.tasksAsTable()
            )
        }
    }
}