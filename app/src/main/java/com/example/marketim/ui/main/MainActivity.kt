package com.example.marketim.ui.main

import android.os.Bundle
import com.example.marketim.R
import com.example.marketim.base.BaseActivity
import com.example.marketim.ui.login.LoginActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (!isLoggedIn())
            launchActivity<LoginActivity>()
    }
}
