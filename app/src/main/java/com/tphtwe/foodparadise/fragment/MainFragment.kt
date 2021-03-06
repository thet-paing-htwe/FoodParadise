package com.tphtwe.foodparadise.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.squareup.picasso.Picasso
import com.tphtwe.foodparadise.R
import com.tphtwe.foodparadise.adapter.CategoryAdapter
import com.tphtwe.foodparadise.model.CategoryX
import com.tphtwe.foodparadise.viewmodel.ViewModelCategory
import com.tphtwe.foodparadise.viewmodel.ViewModelRandom
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment(), CategoryAdapter.ClickListener {
    lateinit var viewModelCategory: ViewModelCategory
    lateinit var viewModelRandom: ViewModelRandom
    lateinit var categoryAdapter: CategoryAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelCategory = ViewModelProvider(this).get(ViewModelCategory::class.java)
        viewModelRandom=ViewModelProvider(this).get(ViewModelRandom::class.java)
        categoryAdapter = CategoryAdapter()


        categoryRecycler.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = categoryAdapter
        }
        observeViewModel()

        categoryAdapter.setOnClickListener(this)

        //Random image click listener


        //letter atoz click Listener
        letterCard.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_atoZFragment)
        }
        //country click Listener
        countryCard.setOnClickListener {
            Toast.makeText(context, "excellent", Toast.LENGTH_SHORT).show()
        }
        //ingrediant click Listener
        ingredientCard.setOnClickListener {
            Toast.makeText(context, "great job", Toast.LENGTH_SHORT).show()
        }




    }

    fun observeViewModel() {
        viewModelCategory.getResultCategory().observe(
            viewLifecycleOwner, Observer {
                categoryAdapter.updateCategoryList(it.categories)
            }
        )
        viewModelRandom.getResultRandom().observe(
            viewLifecycleOwner, Observer{
                Picasso.get().load(it.meals[0].strMealThumb).into(randomImage)
                randomTitle.text=it.meals[0].strMeal
                var id =it.meals[0].idMeal

                randomCard.setOnClickListener {
                    var action=MainFragmentDirections.actionMainFragmentToDetailFragment(id)
                    findNavController().navigate(action)
                }
            }
        )
    }

    override fun onResume() {
        super.onResume()
        viewModelCategory.loadResultCategory()
        viewModelRandom.loadResultRandom()

    }

    override fun click(categoryX: CategoryX) {
       Toast.makeText(context, categoryX.strCategory, Toast.LENGTH_SHORT).show()
        var action=MainFragmentDirections.actionMainFragmentToCategoFragment(categoryX.strCategory)
        findNavController().navigate(action)
    }



}