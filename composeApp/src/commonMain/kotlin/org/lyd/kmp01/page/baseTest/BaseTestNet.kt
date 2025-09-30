package org.lyd.kmp01.page.baseTest

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel
import androidx.compose.runtime.getValue

@Composable
fun BaseTestNet(
    viewModel: BaseTestNetViewModel = koinViewModel<BaseTestNetViewModel>()
) {
    val resultStr by viewModel.resultState.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            viewModel.getArticleList()
        }) {
            Text(text = "获取文章列表")
        }
        Text(text = resultStr)
    }
}