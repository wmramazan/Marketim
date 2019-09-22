package com.example.marketim.api

import com.example.marketim.model.Order
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created on 9/22/2019
 * @author wmramazan
 */
interface ApiService {
    @GET
    fun getOrders(): Call<List<Order>>
}