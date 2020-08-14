package com.tphtwe.foodparadise

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.tphtwe.foodparadise.AtoZList.AtoZList
import kotlinx.android.synthetic.main.fragment_ato_z.*


class AtoZFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ato_z, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var listAtoZ= listOf("1","2")
        var listAto=AtoZList().arrayList
        val arrayAdapter= ArrayAdapter<String>(this.requireContext(), R.layout.support_simple_spinner_dropdown_item, listAto)
        spinner.adapter=arrayAdapter

        spinner.onItemSelectedListener = object  : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {


            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                Toast.makeText(context, p0?.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show()
            }

        }



    }


}