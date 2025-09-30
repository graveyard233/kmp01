package org.lyd.kmp01.network.di

import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import org.lyd.kmp01.expect.getHttpClient
import org.lyd.kmp01.network.WanAndroidNetworkData
import org.lyd.kmp01.network.networkData.WanAndroidNetData
import org.lyd.kmp01.network.repository.WanAndroidRepository

val networkModule = module {
    single {
        Json {
            ignoreUnknownKeys = true
            isLenient = true
        }
    }
    single {
        getHttpClient(json = get())
    }
    singleOf(::WanAndroidNetData).bind(WanAndroidNetworkData::class)
    single {
        WanAndroidRepository(
            wanAndroidNetworkData = get<WanAndroidNetworkData>()// 引用接口而不是实现
        )
    }
}