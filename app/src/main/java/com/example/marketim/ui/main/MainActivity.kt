package com.example.marketim.ui.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marketim.R
import com.example.marketim.adapter.OrderAdapter
import com.example.marketim.base.BaseActivity
import com.example.marketim.model.Order
import com.example.marketim.ui.login.LoginActivity
import com.example.marketim.util.Constants
import com.orhanobut.hawk.Hawk
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity(), MainContract.View {

    private val presenter: MainPresenter by inject()
    private lateinit var orderAdapter: OrderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (!rememberMe() && !isLoggedIn()) {
            launchActivity<LoginActivity>(clearStack = true)
            finish()
            return
        }

        orderAdapter = OrderAdapter()
        recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = orderAdapter
        }

        presenter.attach(this)
        presenter.loadOrders()

        ViewCompat.setElevation(bottom_navigation, .4f)

        button_logout.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle(R.string.logout)
                .setMessage(R.string.logout_dialog_message)
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes) { _, _ -> logout() }
                .show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Hawk.put(Constants.KEY_LOGGED_IN, false)
    }

    override fun showOrders(orders: List<Order>) {
        orderAdapter.orders = orders
    }

    override fun showErrorMessage() {
        showMessage(R.string.something_went_wrong)
    }

    override fun showProgress() {
        progress_bar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress_bar.visibility = View.GONE
    }
}
