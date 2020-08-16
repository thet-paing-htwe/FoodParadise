package com.tphtwe.foodparadise.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import com.tphtwe.foodparadise.adapter.CategoRefAdaptor
import com.tphtwe.foodparadise.api.ApiClient
import com.tphtwe.foodparadise.model.CatogoryFilter.CategoryFilter
import kotlinx.android.synthetic.main.fragment_catego.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryFilterViewModel : ViewModel(){
    var resultCatFiler:MutableLiveData<CategoryFilter> =MutableLiveData<CategoryFilter>()
    fun getCatFilter():LiveData<CategoryFilter> =resultCatFiler

    fun loadCatFilter(id:String){
        var apiClient= ApiClient().getCatogoryFilter(id)
        apiClient.enqueue(object : Callback<CategoryFilter> {
            override fun onFailure(call: Call<CategoryFilter>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<CategoryFilter>,
                response: Response<CategoryFilter>
            ) {
                resultCatFiler.value=response.body()

            }
        })

    }
}