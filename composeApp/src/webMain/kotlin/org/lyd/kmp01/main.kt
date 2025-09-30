package org.lyd.kmp01

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import org.lyd.kmp01.designSystem.AppTheme
import org.lyd.kmp01.designSystem.getTypography


@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport {
        AppTheme { colorScheme ->
            MaterialTheme(
                colorScheme = colorScheme,
                typography = getTypography()
            ) {
                App()
            }
        }
    }
}