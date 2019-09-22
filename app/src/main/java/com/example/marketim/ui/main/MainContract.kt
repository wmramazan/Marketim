package com.example.marketim.ui.main

import com.example.marketim.base.BaseContract
import com.example.marketim.model.Order

/**
 * Created on 9/22/2019
 * @author wmramazan
 */
class MainContract {

    interface View: BaseContract.View {
        fun showErrorMessage()
        fun showOrders(orders: List<Order>)
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun loadOrders()
    }

}