package com.example.myapp

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.databinding.ActivityMainBinding
import com.example.myapp.databinding.RecyclerviewlayoutBinding
import kotlin.reflect.KType
import android.content.Intent
import android.view.MotionEvent
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2


class MyAdapter(val UpList: List<Up>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val upimage:ImageView = itemView.findViewById(R.id.UpImage)
        val upname: TextView = itemView.findViewById(R.id.UpName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerviewlayout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
        val up = UpList[position]
        holder.upimage.setImageResource(up.image)
        holder.upname.text = up.name
        holder.upname.setOnClickListener {
            itemClickListenner?.onItemClike(position)
        }
        holder.upname.setOnLongClickListener {
            itemListenner?.Itemclick(position)
            return@setOnLongClickListener true
        }
        holder.upimage.setOnClickListener {
            itemClickListenner?.onItemClike(position)
        }
        holder.upimage.setOnLongClickListener {
            itemListenner?.Itemclick(position)
            return@setOnLongClickListener true
        }
    }

    override fun getItemCount() = UpList.size

    //增添点击事件变量
    private var itemClickListenner: OnItemClickListenner? = null
    private var itemListenner: ItemClickListenner? = null
    //构造点击事件
    fun setOnItemClickeListener(itemClickListenner: OnItemClickListenner) {
        this.itemClickListenner = itemClickListenner;
    }
    fun setOnItemListenner(itenListenner: ItemClickListenner){
        this.itemListenner=itenListenner
    }
    //将点击事件定义为接口
    public interface OnItemClickListenner {
        fun onItemClike(position: Int)
    }
    public interface ItemClickListenner {
        fun Itemclick(position: Int)
    }
}
