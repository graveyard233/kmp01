package org.lyd.kmp01.page.koin

import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

// 入门教程
// https://juejin.cn/post/7543451693477167150
// 官网入门
// https://insert-koin.io/docs/reference/koin-compose/compose

val koinModule = module {
//    single { KoinViewModel() }
//    viewModelOf(::KoinViewModel)
    viewModel {
        KoinViewModel(get())
    }
}