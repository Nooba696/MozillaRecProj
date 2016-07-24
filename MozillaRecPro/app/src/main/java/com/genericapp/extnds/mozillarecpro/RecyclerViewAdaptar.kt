package com.genericapp.extnds.mozillarecpro

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item.view.*

open class RecyclerViewAdaptar(val context: Context, val items: List<Item>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val sp = context.getSharedPreferences("rvState", Context.MODE_PRIVATE)!!

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder? {
        val li = LayoutInflater.from(parent.context)
        var rvvh: ViewHolder?
        var v: View?
        v = li.inflate(R.layout.item, parent, false)
        rvvh = ViewHolder(v)
        return rvvh
    }

    override fun onBindViewHolder(rvvh: RecyclerView.ViewHolder, position: Int) {
        val holder = rvvh as ViewHolder
        val item = items.elementAt(position)
        Log.d("Resultsb :", "${item.name}")
        holder.setItem(context, item)
    }

    override fun getItemCount(): Int {
        return items.size
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var item: Item? = null

        fun setItem(context: Context, item: Item) {
            this.item = item
            with(itemView) {
                name.text = item.name
                price.text = item.price.toString()
                Picasso.with(context)
                        .load(item.image)
                        .into(image)

                if(sp.contains(item.name))
                {
                    price.visibility = View.VISIBLE
                    image.visibility = View.VISIBLE
                }
                else
                {
                    price.visibility = View.GONE
                    image.visibility = View.GONE
                }

                setOnClickListener {
                    price.visibility = View.VISIBLE
                    image.visibility = View.VISIBLE

                    sp.edit()
                        .putBoolean(item.name,true)
                        .apply()
                }

            }
        }
    }
}