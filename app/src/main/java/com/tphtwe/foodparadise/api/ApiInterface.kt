package com.tphtwe.foodparadise.api

import com.tphtwe.foodparadise.model.AtoZmodel.FirstLetter
import com.tphtwe.foodparadise.model.Category
import com.tphtwe.foodparadise.model.CatogoryFilter.CategoryFilter
import com.tphtwe.foodparadise.model.Instrction.Instruction
import com.tphtwe.foodparadise.model.Random
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("categories.php")
    fun getCategory():Call<Category>
    @GET("random.php")
    fun getRandom():Call<Random>

    //Ypp add first letter
    @GET("search.php")
    fun getFirstLetter(
        @Query("f")letter:String
    ):Call<FirstLetter>

    @GET("lookup.php")
    fun getDetil(
        @Query("i") id:String
    ):Call<Instruction>

    @GET("filter.php")
    fun getCat(
        @Query("c") id: String
    ):Call<CategoryFilter>


}