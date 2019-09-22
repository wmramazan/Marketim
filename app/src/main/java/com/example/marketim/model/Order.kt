package com.example.marketim.model

import com.squareup.moshi.JsonClass

/**
 * Created on 9/22/2019
 * @author wmramazan
 */
@JsonClass(generateAdapter = true)
data class Order(
    val date: String,
    val month: String,
    val marketName: String,
    val orderName: String,
    val productPrice: Float,
    val productState: String,
    val productDetail: ProductDetail
)