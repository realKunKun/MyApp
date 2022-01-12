package com.example.myapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.myapp.MyAdapter.OnItemClickListenner
import com.example.myapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var MyrecyclerView: RecyclerView
    lateinit var Viewpaper: ViewPager2
    private val upList = ArrayList<Up>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //设定其为主Activity
        setContentView(R.layout.activity_main)
        //实例化databinding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //初始化各种组
        initList()
        //recyclerView部
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        MyrecyclerView = binding.Recyc
        MyrecyclerView.layoutManager = layoutManager
        val adapter = MyAdapter(upList)
        //同步转换
        adapter.setOnItemClickeListener(object: OnItemClickListenner{
            override fun onItemClike(position: Int) {
                Viewpaper.currentItem = position
                Log.d("头像或名字点击", upList[position].toString())
            }
        })
        adapter.setOnItemListenner(object: MyAdapter.ItemClickListenner{
            override fun Itemclick(position:Int){
                var intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("UpImformation", upList[position])
                startActivityForResult(intent,0)
                //finish()
            }
        })
        MyrecyclerView.adapter = adapter
        //Viewpaper部分
        Viewpaper = binding.Viewpaper
        val ViewpaperAdapter = Vadapter(upList)
        Viewpaper.adapter = ViewpaperAdapter
        //取关删除

    }
    @SuppressLint("NotifyDataSetChanged")
    @Override
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
      if(requestCode==0 && resultCode== RESULT_OK){
          var up_delete = data?.getSerializableExtra("UpImformation") as Up
          Log.d("删除up", up_delete.name)
          upList.remove(up_delete)
          MyrecyclerView.adapter?.notifyDataSetChanged()
          Viewpaper.adapter?.notifyDataSetChanged()
      }

    }
    private fun initList() {
        upList.add(Up("Iyanagi Yuri", 20, R.drawable.iyanagiyuri, R.drawable.dynamic1, "1"))
        upList.add(Up("Misaki Naoko", 21, R.drawable.misakinaoko, R.drawable.dynamic2, "1"))
        upList.add(Up("Liyuu_", 24, R.drawable.liyuu, R.drawable.dynamic3, "4"))
        upList.add(Up("Payton Naomi", 18, R.drawable.payton, R.drawable.dynamic4, "5"))
        upList.add(Up("Aoyama Nagisa", 22, R.drawable.aoyamanagisa, R.drawable.dynamic5, "1"))
        upList.add(Up("Trump", 78, R.drawable.trump, R.drawable.dynamic6, "4"))
        upList.add(Up("Biden", 81, R.drawable.biden, R.drawable.dynamic7, "1919"))
        upList.add(Up("KunKun", 24, R.drawable.kunkun, R.drawable.dynamic8, "810"))
    }
}