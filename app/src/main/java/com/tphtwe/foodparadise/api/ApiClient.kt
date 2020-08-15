package com.tphtwe.foodparadise.api

import com.tphtwe.foodparadise.model.AtoZmodel.FirstLetter
import com.tphtwe.foodparadise.model.Category
import com.tphtwe.foodparadise.model.Random
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class ApiClient {
    val BASEURL="https://www.themealdb.com/api/json/v1/1/"
    var apiInterface:ApiInterface
    init {
        var retrofit=Retrofit.Builder().baseUrl(BASEURL).addConverterFactory(GsonConverterFactory.create()).build()
        apiInterface=retrofit.create(ApiInterface::class.java)
    }
    fun getCategories():Call<Category>{
        return apiInterface.getCategory()
    }
    fun getRandoms():Call<Random>{
        return apiInterface.getRandom()
    }

    //Ypp add firstletter
    fun getFirstLetter(letter:String):Call<FirstLetter>{
        return apiInterface.getFirstLetter(letter)
    }
}