package org.lyd.kmp01

import io.ktor.serialization.kotlinx.KotlinxWebsocketSerializationConverter
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.routing.routing
import io.ktor.server.websocket.DefaultWebSocketServerSession
import io.ktor.server.websocket.WebSocketServerSession
import io.ktor.server.websocket.WebSockets
import io.ktor.server.websocket.pingPeriod
import io.ktor.server.websocket.receiveDeserialized
import io.ktor.server.websocket.sendSerialized
import io.ktor.server.websocket.timeout
import io.ktor.server.websocket.webSocket
import io.ktor.websocket.CloseReason
import io.ktor.websocket.close
import kotlinx.coroutines.delay
import org.lyd.kmp01.module.Task
import org.lyd.kmp01.module.TaskRepository
import java.util.Collections
import kotlin.time.Duration.Companion.seconds

fun Application.configureSockets(){
    install(WebSockets){
        contentConverter = KotlinxWebsocketSerializationConverter(json)
        pingPeriod = 15.seconds
        timeout = 15.seconds
        maxFrameSize = Long.MAX_VALUE
        masking = false
    }
    routing {
        val sessions =
            Collections.synchronizedList<WebSocketServerSession>(ArrayList())

        webSocket("/allBySocket") {
            sendAllTasks()
            close(CloseReason(CloseReason.Codes.NORMAL,"all done"))
        }
        webSocket("/taskBySocket") {
            sessions.add(this)
            sendAllTasks()

            while (true){
                val newTask = receiveDeserialized<Task>()
                TaskRepository.addTask(newTask)
                for (session in sessions){
                    session.sendSerialized(newTask)
                }
            }
        }
    }

}

private suspend fun DefaultWebSocketServerSession.sendAllTasks() {
    for (task in TaskRepository.tasks) {
        sendSerialized(task)
        delay(1000)
    }
}