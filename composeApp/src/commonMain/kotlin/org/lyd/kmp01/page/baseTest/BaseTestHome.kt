package org.lyd.kmp01.page.baseTest

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.lyd.kmp01.nav.AppState
import org.lyd.kmp01.nav.RouteName

@Composable
fun BaseTestHome(
    appState: AppState
) {
    val navList = listOf<String>(
        RouteName.BASE_TEST_NET,
        RouteName.BASE_TEST_IMG
    )
    FlowRow(
        modifier = Modifier
            .fillMaxSize(),
        maxItemsInEachRow = 2
    ) {
        navList.forEach { navName ->
            Card(
                modifier = Modifier
                    .padding(5.dp)
                    .weight(1f)
                    .clickable(onClick = {
                        appState.navController.navigate(navName)
                    })
            ) {
                Text(
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = navName
                )
            }
        }
    }
}