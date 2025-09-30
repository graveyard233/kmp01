package org.lyd.kmp01.page.baseTest

import coil3.ImageLoader
import coil3.SingletonImageLoader
import coil3.compose.setSingletonImageLoaderFactory
import coil3.disk.DiskCache
import coil3.memory.MemoryCache
import coil3.request.CachePolicy
import coil3.request.crossfade
import org.koin.dsl.module

val coilModule = module(createdAtStart = true) {
    single {
        SingletonImageLoader.setSafe { context ->
            ImageLoader.Builder(context)
                .crossfade(1000)
                .build()
        }
    }
}