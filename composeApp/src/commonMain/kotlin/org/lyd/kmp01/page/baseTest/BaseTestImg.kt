package org.lyd.kmp01.page.baseTest

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import kmp01.composeapp.generated.resources.Res
import kmp01.composeapp.generated.resources.sample01

@Composable
fun BaseTestImg() {
    val imgUrlList = listOf(
        "https://picsum.photos/300/300?random=1",
        "https://picsum.photos/300/300?random=2",
        "https://picsum.photos/300/300?random=3",
        "https://picsum.photos/300/300?random=4",
        "https://picsum.photos/300/300?random=5",
        "https://picsum.photos/300/300?random=6",
        "https://picsum.photos/300/300?random=7",
        "https://picsum.photos/300/300?random=8",
        "https://picsum.photos/300/300?random=9"
    )
    val localImgUriList = listOf(
        "sample01.jpg"
    )
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            imgUrlList.forEach { url ->
                item {
                    AsyncImage(
                        model = url,
                        contentDescription = null,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .padding(4.dp)
                            .background(Color.Gray),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            localImgUriList.forEach { localImgUri ->
                item {
                    AsyncImage(
                        model = Res.getUri("drawable/$localImgUri"),// 在桌面端上有问题
                        contentDescription = null,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .padding(4.dp)
                            .background(Color.Gray),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    }
}