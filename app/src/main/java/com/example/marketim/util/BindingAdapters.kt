package com.example.marketim.util

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.marketim.R

/**
 * Created on 9/22/2019
 * @author wmramazan
 */
@BindingAdapter("state")
fun setStateBackground(view: View, state: String) {
    view.setBackgroundResource(
        when (state) {
            "Yolda" -> R.drawable.view_state_green
            "Hazırlanıyor" -> R.drawable.view_state_orange
            "Onay Bekliyor" -> R.drawable.view_state_red
            else    -> R.drawable.view_state_green
        }
    )
}

@BindingAdapter("stateText")
fun setStateColor(view: TextView, stateText: String) {
    view.setTextColor(
        ContextCompat.getColor(view.context, when (stateText) {
            "Yolda" -> R.color.green
            "Hazırlanıyor" -> R.color.orange
            "Onay Bekliyor" -> R.color.red
            else    -> R.color.green
        })
    )
}

