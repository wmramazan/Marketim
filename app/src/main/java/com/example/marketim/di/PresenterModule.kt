package com.example.marketim.di

import com.example.marketim.ui.login.LoginPresenter
import org.koin.dsl.module

/**
 * Created on 9/22/2019
 * @author wmramazan
 */
val presenterModule = module {
    factory { LoginPresenter() }
}