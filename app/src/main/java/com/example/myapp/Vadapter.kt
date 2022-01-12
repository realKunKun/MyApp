package com.example.myapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Vadapter(val upList:List<Up>) : RecyclerView.Adapter<Vadapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val upimage: ImageView =itemView.findViewById(R.id.VpImage)
        val upname: TextView =itemView.findViewById(R.id.VpText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vadapter.ViewHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.viewpaperlayout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var up=upList[position]
        
        holder.upimage.setImageResource(up.Dynamic)
        holder.upname.text="Up主的名字："+up.name
    }

    override fun getItemCount()=upList.size
}