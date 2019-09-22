package com.example.marketim.ui.main

import com.example.marketim.api.ApiService
import com.example.marketim.model.Order
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

/**
 * Created on 9/22/2019
 * @author wmramazan
 */
class MainPresenter(val api: ApiService) : MainContract.Presenter {

    private lateinit var view: MainContract.View

    override fun attach(view: MainContract.View) {
        this.view = view
    }

    override fun loadOrders() {
        Timber.d("loadOrders")
        view.showProgress()

        api.getOrders().enqueue(object : Callback<List<Order>> {
            override fun onResponse(call: Call<List<Order>>, response: Response<List<Order>>) {
                response.body()?.also {
                    view.showOrders(it)
                }

                view.hideProgress()
            }

            override fun onFailure(call: Call<List<Order>>, t: Throwable) {
                view.showErrorMessage()
                view.hideProgress()
            }
        })
    }

}