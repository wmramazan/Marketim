package com.example.marketim.ui.login

import android.os.Bundle
import com.afollestad.vvalidator.form
import com.example.marketim.R
import com.example.marketim.base.BaseActivity
import com.example.marketim.ui.main.MainActivity
import com.example.marketim.util.Constants
import com.orhanobut.hawk.Hawk
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.inject
import timber.log.Timber

class LoginActivity : BaseActivity(), LoginContract.View {

    private val presenter: LoginPresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter.attach(this)

        form {
            inputLayout(layout_input_username) {
                isNotEmpty().description(R.string.enter_username)
            }

            inputLayout(layout_input_password) {
                isNotEmpty().description(R.string.enter_password)
            }

            submitWith(button_login) {
                presenter.validateUser(
                    input_username.text.toString(),
                    input_password.text.toString()
                )
            }
        }
    }

    override fun showErrorMessage() {
        showMessage(R.string.wrong_username_or_password)
    }

    override fun login() {
        Timber.d("Success Login")

        Hawk.put(Constants.KEY_LOGGED_IN, true)
        Hawk.put(Constants.KEY_REMEMBER_ME, switch_remember_me.isChecked)

        launchActivity<MainActivity>()
    }

}
