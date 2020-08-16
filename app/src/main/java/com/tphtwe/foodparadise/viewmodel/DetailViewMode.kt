package com.tphtwe.foodparadise.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tphtwe.foodparadise.api.ApiClient
import com.tphtwe.foodparadise.model.Instrction.Instruction
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewMode : ViewModel(){
    private var resultdetail : MutableLiveData<Instruction> =MutableLiveData<Instruction>()
    fun getDetail() : LiveData<Instruction> = resultdetail

    fun loadResultDetail(id:String){
        var apiClient =ApiClient().getDetail(id)
        apiClient.enqueue(object : Callback<Instruction>{
            override fun onFailure(call: Call<Instruction>, t: Throwable) {


            }

            override fun onResponse(call: Call<Instruction>, response: Response<Instruction>) {
            resultdetail.value=response.body()
            }

        })

    }

}