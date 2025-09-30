package org.lyd.kmp01

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json

private const val MY_SERVER_PORT = 9292

val json = Json {
    ignoreUnknownKeys = true
    isLenient = true
}

fun main() {
    embeddedServer(
        Netty,
//        port = SERVER_PORT,
        port = MY_SERVER_PORT,
        host = "0.0.0.0",
        module = Application::module
    ).start(
        wait = true
    )
}

fun Application.module() {
    configureHTTP()
    configureRouting()
    configureSerialization()
    configureSockets()
}