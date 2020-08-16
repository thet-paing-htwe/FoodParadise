package com.tphtwe.foodparadise.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tphtwe.foodparadise.R
import com.tphtwe.foodparadise.model.CatogoryFilter.Meal
import kotlinx.android.synthetic.main.item_a_to_z.view.*

class CategoRefAdaptor(var catList: List<Meal> = ArrayList<Meal>()) :
    RecyclerView.Adapter<CategoRefAdaptor.CategoViewHolder>() {

    var catClister: Clister? = null
    fun onClickLister(clister: Clister) {
        this.catClister = clister
    }

    inner class CategoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        lateinit var meal2: Meal

        fun bindCat(meal: Meal) {
            this.meal2=meal
            itemView.firstLetterTxt.text = meal.strMeal
            Picasso.get().load(meal.strMealThumb).into(itemView.firstLetterImg)
        }

        override fun onClick(p0: View?) {
            catClister?.click(meal2)

        }

    }

    fun updateCatFilter(catList: List<Meal>) {
        this.catList = catList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_a_to_z, parent, false)
        return CategoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return catList.size
    }

    override fun onBindViewHolder(holder: CategoViewHolder, position: Int) {
        holder.bindCat(catList[position])
    }

    interface Clister {
        fun click(meal: Meal)
    }
}