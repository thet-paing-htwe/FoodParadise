package com.tphtwe.foodparadise

import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import com.tphtwe.foodparadise.api.ApiClient
import com.tphtwe.foodparadise.fragment.Descripion.DesciptionFragment
import com.tphtwe.foodparadise.model.Instrction.Instruction
import com.tphtwe.foodparadise.model.Instrction.Meal
import com.tphtwe.foodparadise.viewmodel.DetailViewMode
import kotlinx.android.synthetic.main.fragment_desciption.*
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_youtube.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailFragment : Fragment() {
    lateinit var detailViewMode: DetailViewMode




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailViewMode=ViewModelProvider(this).get(DetailViewMode::class.java)

        var desciptionFragment=DesciptionFragment()
        val trascation=activity?.supportFragmentManager?.beginTransaction()
        trascation?.add(R.id.detilFrame, desciptionFragment)
        trascation?.commit()




        btnRecipe.setOnClickListener {
            var instruction=instrctionDetil.text

            var desciptionFragment = DesciptionFragment( )
            var bundle=Bundle()
            bundle.putString("text",instrctionDetil.text.toString())
            desciptionFragment.arguments=bundle

            val transcation = activity?.supportFragmentManager?.beginTransaction()
            transcation?.replace(R.id.detilFrame, desciptionFragment)
            transcation?.commit()

        }
        observedViewModel()


    }
    fun observedViewModel(){
        detailViewMode.getDetail().observe(
            viewLifecycleOwner, Observer {
                detilTitle.text=it.meals.get(0).strMeal
                detilCat.text=it.meals.get(0).strCategory
                detilCountry.text=it.meals.get(0).strArea
                Picasso.get().load(it.meals[0].strMealThumb).into(detilImg)
                instrctionDetil.text=it.meals[0].strInstructions
                var youtube=it.meals[0].strYoutube
                

                btnIngre.setOnClickListener{

                    var ingreFragment=IngreFragment()
                    var bundle=Bundle()
                    bundle.putStringArrayList("yy", arrayListOf("77","55"))
                    var transaction=activity?.supportFragmentManager?.beginTransaction()
                    transaction?.replace(R.id.detilFrame,ingreFragment)
                    transaction?.commit()
                }

                btnYoutube.setOnClickListener{

                    var youtubeFragment=YoutubeFragment()
                    var bundle=Bundle()
                    bundle.putString("youtube",youtube)
                    var transaction=activity?.supportFragmentManager?.beginTransaction()
                    transaction?.replace(R.id.detilFrame,youtubeFragment)
                    transaction?.commit()
                }







            }
        )
    }

    override fun onResume() {
        super.onResume()

        var arguments=arguments?.let {
            DetailFragmentArgs.fromBundle(it)
        }
        var id:String=arguments?.description.toString()

        detailViewMode.loadResultDetail(id)




    }


}