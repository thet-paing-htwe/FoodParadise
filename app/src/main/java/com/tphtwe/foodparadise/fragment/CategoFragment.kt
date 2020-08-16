package com.tphtwe.foodparadise.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.tphtwe.foodparadise.R
import com.tphtwe.foodparadise.adapter.CategoRefAdaptor
import com.tphtwe.foodparadise.adapter.CategoryAdapter
import com.tphtwe.foodparadise.api.ApiClient
import com.tphtwe.foodparadise.model.CatogoryFilter.CategoryFilter
import com.tphtwe.foodparadise.model.CatogoryFilter.Meal
import com.tphtwe.foodparadise.viewmodel.CategoryFilterViewModel
import kotlinx.android.synthetic.main.fragment_catego.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CategoFragment : Fragment(),CategoRefAdaptor.Clister {
        lateinit var catFilViewModel:CategoryFilterViewModel
        lateinit var catfAdaptor: CategoRefAdaptor

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_catego, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        catFilViewModel=ViewModelProvider(this).get(CategoryFilterViewModel::class.java)
        catfAdaptor= CategoRefAdaptor()



        catFilterRecycler.apply {
            layoutManager= GridLayoutManager(context,2)
            adapter= catfAdaptor
        }
        observedViewModel()
        catfAdaptor.onClickLister(this)



    }
    fun observedViewModel(){
        catFilViewModel.getCatFilter().observe(
            viewLifecycleOwner, Observer {
                catfAdaptor.updateCatFilter(it.meals)
            }
        )
    }

    override fun onResume() {
        super.onResume()
        var arguments=arguments?.let {
            CategoFragmentArgs.fromBundle(it)
        }
        var id=arguments?.id.toString()
        catFilViewModel.loadCatFilter(id)

    }

    override fun click(meal: Meal) {
        var action=CategoFragmentDirections.actionCategoFragmentToDetailFragment(meal.idMeal)
        findNavController().navigate(action)
    }


}