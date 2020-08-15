package com.tphtwe.foodparadise.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tphtwe.foodparadise.R

import com.tphtwe.foodparadise.model.AtoZmodel.Meal
import kotlinx.android.synthetic.main.item_a_to_z.view.*

class FirstLetterAdaptor(var firstLetterList: List<Meal>):RecyclerView.Adapter<FirstLetterAdaptor.FirstLetterViewHolder>() {
    class FirstLetterViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        fun bindFirstLetter(meal: Meal){
            itemView.firstLetterTxt.text=meal.strMeal
            Picasso.get().load(meal.strMealThumb).placeholder(R.drawable.hhh).into(itemView.firstLetterImg)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstLetterViewHolder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.item_a_to_z,parent,false)
        return FirstLetterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return firstLetterList.size
    }

    override fun onBindViewHolder(holder: FirstLetterViewHolder, position: Int) {
        holder.bindFirstLetter(firstLetterList[position])
    }
}