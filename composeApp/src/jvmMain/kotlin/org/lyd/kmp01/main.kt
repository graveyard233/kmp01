package org.lyd.kmp01

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.lyd.kmp01.designSystem.AppTheme

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "KMP01",
    ) {
        AppTheme { colorScheme ->
            MaterialTheme(
                colorScheme = colorScheme
            ) {
                App()
            }
        }
    }
}