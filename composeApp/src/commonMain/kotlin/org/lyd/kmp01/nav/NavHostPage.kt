package org.lyd.kmp01.nav

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.navigation
import kmp01.composeapp.generated.resources.Res
import kmp01.composeapp.generated.resources.chevron_left_24
import org.jetbrains.compose.resources.painterResource
import org.lyd.kmp01.App
import org.lyd.kmp01.page.NavHome
import org.lyd.kmp01.page.baseTest.BaseTestHome
import org.lyd.kmp01.page.baseTest.BaseTestImg
import org.lyd.kmp01.page.baseTest.BaseTestNet
import org.lyd.kmp01.page.koin.KoinHomePage
import org.lyd.kmp01.page.koin.KoinViewModelPage


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavHost(
    appState: AppState
){
    val backStackEntry by appState.navController.currentBackStackEntryAsState()
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = backStackEntry?.destination?.route ?: "")
                },
                navigationIcon = {
                    if (backStackEntry?.destination?.route != RouteName.NAV_HOME){
                        IconButton(onClick = {
                            appState.navController.popBackStack()
                        }) {
                            Icon(painter = painterResource(Res.drawable.chevron_left_24), contentDescription = "")
                        }
                    }
                }
            )
        }
    ) { paddingValues ->
        NavHost(
            modifier = Modifier
                .padding(paddingValues),
            navController = appState.navController,
            startDestination = RouteName.NAV_HOME
        ) {
            composable(RouteName.NAV_HOME) {
                NavHome(appState)
            }

            navigation(startDestination = RouteName.KOIN_HOME, route = RouteName.KOIN){
                composable(RouteName.KOIN_HOME) {
                    KoinHomePage(appState = appState)
                }
                composable(RouteName.KOIN_VIEWMODEL) {
                    KoinViewModelPage()
                }
            }

            navigation(startDestination = RouteName.BASE_TEST_HOME, route = RouteName.BASE_TEST){
                composable(RouteName.BASE_TEST_HOME) {
                    BaseTestHome(appState = appState)
                }
                composable(RouteName.BASE_TEST_NET) {
                    BaseTestNet()
                }
                composable(RouteName.BASE_TEST_IMG) {
                    BaseTestImg()
                }
            }
        }
    }

}