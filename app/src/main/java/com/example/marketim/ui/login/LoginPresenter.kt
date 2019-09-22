package com.example.marketim.ui.login

import com.example.marketim.util.Constants

/**
 * Created on 9/22/2019
 * @author wmramazan
 */
class LoginPresenter : LoginContract.Presenter {

    private lateinit var view: LoginContract.View

    override fun attach(view: LoginContract.View) {
        this.view = view
    }

    override fun validateUser(username: String, password: String) {
        if (username == Constants.USERNAME && password == Constants.PASSWORD)
            view.login()
        else
            view.showErrorMessage()
    }

}