package org.lyd.kmp01.designSystem

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
infix fun Color.onLight(lightColor: Color): Color =
    if (!isDarkTheme()) lightColor else this

@Composable
infix fun Color.onDark(darkColor: Color): Color =
    if (isDarkTheme()) darkColor else this


@Composable
fun isDarkTheme(): Boolean {
    return when(LocalDarkThemeState.current){
        FOLLOW_SYSTEM -> isSystemInDarkTheme()
        DARK_ON -> true
        DARK_OFF -> false
        else -> false
    }
}

