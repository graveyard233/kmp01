package org.lyd.kmp01.designSystem

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import org.lyd.kmp01.designSystem.colors.BlueDarkScheme
import org.lyd.kmp01.designSystem.colors.BlueLightScheme
import org.lyd.kmp01.designSystem.colors.GreenDarkScheme
import org.lyd.kmp01.designSystem.colors.GreenLightScheme
import org.lyd.kmp01.designSystem.colors.RedDarkScheme
import org.lyd.kmp01.designSystem.colors.RedLightScheme
import org.lyd.kmp01.designSystem.colors.YellowDarkScheme
import org.lyd.kmp01.designSystem.colors.YellowLightScheme

@Deprecated(
    message = "Use BLUE_THEME instead",
    replaceWith = ReplaceWith("BLUE_THEME")
)
/**壁纸动态主题色（限Android12及以上，12以下则默认使用[BLUE_THEME]）*/
const val WALLPAPER_THEME = 0
const val BLUE_THEME = 1
const val GREEN_THEME = 2
const val RED_THEME = 3
const val YELLOW_THEME = 4

const val FOLLOW_SYSTEM = 0
const val DARK_ON = 1
const val DARK_OFF = 2

/**
 * 使用哪一种主题，但现在是跨平台架构，所以默认使用蓝色
 * */
val LocalThemeState = compositionLocalOf { BLUE_THEME }
/**[FOLLOW_SYSTEM]是跟随系统，[DARK_ON]是强制夜间模式*/
val LocalDarkThemeState = compositionLocalOf { FOLLOW_SYSTEM }

@Composable
fun AppTheme(
    useDarkTheme: Boolean = isDarkTheme(),
    platformInit: @Composable (colorScheme: ColorScheme)-> Unit,
) {
    val colorScheme = if (useDarkTheme){
        when(LocalThemeState.current){
            BLUE_THEME -> BlueDarkScheme
            GREEN_THEME -> GreenDarkScheme
            RED_THEME -> RedDarkScheme
            YELLOW_THEME -> YellowDarkScheme
            else -> BlueDarkScheme
        }
    } else {
        when(LocalThemeState.current){
            BLUE_THEME -> BlueLightScheme
            GREEN_THEME -> GreenLightScheme
            RED_THEME -> RedLightScheme
            YELLOW_THEME -> YellowLightScheme
            else -> BlueLightScheme
        }
    }

    platformInit(colorScheme)
}

