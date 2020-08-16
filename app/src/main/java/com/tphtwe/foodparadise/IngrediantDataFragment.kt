package com.tphtwe.foodparadise

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.tphtwe.foodparadise.api.ApiClient
import com.tphtwe.foodparadise.model.Instrction.Instruction
import com.tphtwe.foodparadise.model.Instrction.Meal
import kotlinx.android.synthetic.main.fragment_ingrediant_data.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class IngrediantDataFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ingrediant_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var id=arguments?.getString("mm").toString()
        var apiClient= ApiClient().getDetail(id)
        apiClient.enqueue(object : Callback<Instruction>{
            override fun onFailure(call: Call<Instruction>, t: Throwable) {
            }

            override fun onResponse(call: Call<Instruction>, response: Response<Instruction>) {


            }

        })
        
    }


}