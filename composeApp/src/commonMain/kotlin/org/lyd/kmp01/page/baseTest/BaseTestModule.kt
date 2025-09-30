package org.lyd.kmp01.page.baseTest


import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val baseTestModule = module {
    viewModel {
        BaseTestNetViewModel(get())
    }
}