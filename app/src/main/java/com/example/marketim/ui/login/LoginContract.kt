package com.example.marketim.ui.login

import com.example.marketim.base.BaseContract

/**
 * Created on 9/22/2019
 * @author wmramazan
 */
class LoginContract {

    interface View: BaseContract.View {
        fun showErrorMessage()
        fun login()
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun validateUser(username: String, password: String)
    }

}