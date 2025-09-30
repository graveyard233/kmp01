package org.lyd.kmp01

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import kmp01.composeapp.generated.resources.Res
import kmp01.composeapp.generated.resources.compose_multiplatform
import org.koin.compose.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.lyd.kmp01.designSystem.AppTheme
import org.lyd.kmp01.nav.NavHost
import org.lyd.kmp01.nav.rememberAppState
import org.lyd.kmp01.network.di.networkModule
import org.lyd.kmp01.page.baseTest.baseTestModule
import org.lyd.kmp01.page.baseTest.coilModule
import org.lyd.kmp01.page.koin.koinModule

@Composable
fun App() {
    KoinApplication(application = {
        modules(
            koinModule,
            networkModule,
            baseTestModule,
            coilModule,
        )
    }) {
        val navController = rememberNavController()
        val appState = rememberAppState(navController = navController)
        NavHost(appState = appState)
    }
}


@Composable
@Preview
private fun Material3App(){
    AppTheme { colorScheme ->
        MaterialTheme(
            colorScheme = colorScheme
        ) {
            App()
        }
    }
}
