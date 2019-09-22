package com.example.marketim

import android.app.Application
import com.example.marketim.di.networkModule
import com.example.marketim.util.ReleaseTree
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

/**
 * Created on 9/22/2019
 * @author wmramazan
 */
class Marketim : Application() {

    override fun onCreate() {
        super.onCreate()

        configureLog()
        configureDi()
    }

    private fun configureLog() = Timber.plant(
        if (BuildConfig.DEBUG) Timber.DebugTree() else ReleaseTree()
    )

    private fun configureDi() = startKoin {
        androidContext(this@Marketim)
        modules(listOf(
            networkModule
        ))
    }

}