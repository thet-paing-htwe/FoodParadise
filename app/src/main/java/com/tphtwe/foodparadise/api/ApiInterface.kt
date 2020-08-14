package com.tphtwe.foodparadise.api

import com.tphtwe.foodparadise.model.Category
import com.tphtwe.foodparadise.model.Random
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("categories.php")
    fun getCategory():Call<Category>
    @GET("random.php")
    fun getRandom():Call<Random>

}