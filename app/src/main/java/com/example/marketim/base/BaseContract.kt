package com.example.marketim.base

/**
 * Created on 9/22/2019
 * @author wmramazan
 */
class BaseContract {

    interface Presenter<in T> {
        fun attach(view: T)
    }

    interface View {
        fun showProgress()
        fun hideProgress()
    }

}