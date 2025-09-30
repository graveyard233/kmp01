package org.lyd.kmp01

import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.http.content.staticResources
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.request.receive
import io.ktor.server.request.receiveParameters
import io.ktor.server.response.respond
import io.ktor.server.response.respondFile
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import io.ktor.server.routing.routing
import kotlinx.serialization.SerializationException
import org.lyd.kmp01.module.Priority
import org.lyd.kmp01.module.Task
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
        // 使用方法: /task-ui/task_form.html
        staticResources("/task-ui", "task-ui")
        route("/tasks") {
            get {
//                call.respondText(
//                    contentType = ContentType.parse("text/html"),
//                    text = TaskRepository.tasks.tasksAsTable()
//                )
                call.respond(TaskRepository.tasks)
            }
            get("/byName/{taskName}") {
                val name = call.parameters["taskName"]
                if (name == null) {
                    call.respond(HttpStatusCode.BadRequest)
                    return@get
                }

                val task = TaskRepository.taskByName(name)
                if (task == null) {
                    call.respond(HttpStatusCode.NotFound)
                    return@get
                }
                call.respond(task)
            }
            get("/byPriority/{priority}") {
                val priorityAsText = call.parameters["priority"]
                if (priorityAsText == null) {
                    call.respond(HttpStatusCode.BadRequest)
                    return@get
                }
                try {
                    val priority = Priority.valueOf(priorityAsText)
                    val tasks = TaskRepository.tasksByPriority(priority)

                    if (tasks.isEmpty()) {
                        call.respond(HttpStatusCode.NotFound)
                        return@get
                    }
                    call.respond(tasks)
                } catch (ex: IllegalArgumentException) {
                    call.respond(HttpStatusCode.BadRequest)
                }
            }
            post {
                try {
                    val task = call.receive<Task>()
                    TaskRepository.addTask(task)
                    call.respond(HttpStatusCode.Created)
                } catch (ex: IllegalStateException) {
                    call.respond(HttpStatusCode.BadRequest)
                } catch (ex: SerializationException) {
                    call.respond(HttpStatusCode.BadRequest)
                }
            }
            post("/deleteByName") {
                try {
                    val formContent = call.receiveParameters()
                    val name = formContent["name"]
                    if (name == null || name.isEmpty()) {
                        call.respond(HttpStatusCode.BadRequest, "Task name is required")
                        return@post
                    }

                    val removed = TaskRepository.removeTask(name)
                    if (removed) {
                        call.respond(HttpStatusCode.OK, "Task deleted successfully")
                    } else {
                        call.respond(HttpStatusCode.NotFound, "Task not found")
                    }
                } catch (ex: Exception) {
                    call.respond(HttpStatusCode.BadRequest, "Invalid request")
                }
            }

        }
    }
}