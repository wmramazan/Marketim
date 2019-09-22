package com.example.marketim.model

import com.squareup.moshi.JsonClass

/**
 * Created on 9/22/2019
 * @author wmramazan
 */
@JsonClass(generateAdapter = true)
data class ProductDetail(
    val orderDetail: String,
    val summaryPrice: Float) {

    val summaryPriceString: String
        get() = "${summaryPrice}TL"

}