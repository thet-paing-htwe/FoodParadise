package com.tphtwe.foodparadise.fragment.Descripion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.squareup.picasso.Picasso
import com.tphtwe.foodparadise.DetailFragmentArgs
import com.tphtwe.foodparadise.R
import com.tphtwe.foodparadise.viewmodel.DetailViewMode
import com.tphtwe.foodparadise.viewmodel.ViewModelRandom
import kotlinx.android.synthetic.main.fragment_desciption.*
import kotlinx.android.synthetic.main.fragment_detail.*


class DesciptionFragment : Fragment() {
    lateinit var detailViewMode: DetailViewMode

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_desciption, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //observedViewModel()

    }
//    fun observedViewModel(){
//        detailViewMode.getDetail().observe(
//            viewLifecycleOwner, Observer{
//
//                instrctionDetil.text=it.meals[0].strInstructions




//
//            }
//        )
//    }

//    override fun onResume() {
//        super.onResume()
//
//        var arguments=arguments?.let {
//            DetailFragmentArgs.fromBundle(it)
//        }
//        var id:String=arguments?.description.toString()
//
//        detailViewMode.loadResultDetail(id)
//
//    }



}