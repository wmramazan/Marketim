package com.example.marketim.base

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.marketim.util.Constants
import com.orhanobut.hawk.Hawk

/**
 * Created on 9/22/2019
 * @author wmramazan
 */
abstract class BaseActivity : AppCompatActivity() {

    inline fun <reified T : Any> newIntent(context: Context): Intent =
        Intent(context, T::class.java)

    inline fun <reified T : BaseActivity> launchActivity() {
        val intent = newIntent<T>(this)
        startActivity(intent)
    }

    fun isLoggedIn(): Boolean = Hawk.get(Constants.KEY_LOGGED_IN) ?: false

}