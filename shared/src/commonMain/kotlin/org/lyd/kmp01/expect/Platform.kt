package org.lyd.kmp01.expect

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform