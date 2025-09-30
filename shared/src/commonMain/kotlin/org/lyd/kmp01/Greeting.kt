package org.lyd.kmp01

import org.lyd.kmp01.expect.getPlatform

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}