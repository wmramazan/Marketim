package com.example.marketim.base

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.marketim.ui.login.LoginActivity
import com.example.marketim.util.Constants
import com.orhanobut.hawk.Hawk
import timber.log.Timber

/**
 * Created on 9/22/2019
 * @author wmramazan
 */
abstract class BaseActivity : AppCompatActivity() {

    inline fun <reified T : Any> newIntent(context: Context): Intent =
        Intent(context, T::class.java)

    inline fun <reified T : BaseActivity> launchActivity(clearStack: Boolean = false) {
        val intent = newIntent<T>(this)
        if (clearStack)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }

    fun isLoggedIn(): Boolean = Hawk.get(Constants.KEY_LOGGED_IN) ?: false

    fun rememberMe(): Boolean = Hawk.get(Constants.KEY_REMEMBER_ME) ?: false

    fun logout() {
        Hawk.deleteAll()
        launchActivity<LoginActivity>(clearStack = true)
    }

    fun showMessage(resId: Int) = Toast.makeText(this, resId, Toast.LENGTH_LONG).show()

    open fun showProgress() {
        Timber.d("showProgress")
    }

    open fun hideProgress() {
        Timber.d("hideProgress")
    }

}