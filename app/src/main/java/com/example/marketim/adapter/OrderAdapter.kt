package com.example.marketim.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.marketim.R
import com.example.marketim.databinding.ItemOrderBinding
import com.example.marketim.model.Order

/**
 * Created on 9/22/2019
 * @author wmramazan
 */
class OrderAdapter : RecyclerView.Adapter<OrderViewHolder>() {
    var orders: List<Order> = emptyList()
        set(value) {
            field = value

            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val withDataBinding: ItemOrderBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            OrderViewHolder.LAYOUT,
            parent,
            false)
        return OrderViewHolder(withDataBinding)
    }

    override fun getItemCount(): Int = orders.size

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        holder.viewDataBinding.also {
            it.order = orders[position]
            it.executePendingBindings()
        }
    }
}

class OrderViewHolder(val viewDataBinding: ItemOrderBinding) :
    RecyclerView.ViewHolder(viewDataBinding.root) {
    companion object {
        @LayoutRes
        val LAYOUT = R.layout.item_order
    }
}