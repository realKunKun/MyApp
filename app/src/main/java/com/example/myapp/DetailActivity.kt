package com.example.myapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.myapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityDetailBinding
    private lateinit var up: Up
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_detail)
     //binding = ActivityDetailBinding.inflate(layoutInflater)
     setContentView(binding.root)
        up= intent.getSerializableExtra("UpImformation") as Up
        var name=binding.DetextView
        var fan=binding.DetextView2
        var upimage=binding.DeimageView
        name.setText("UP名字："+up.name)
        fan.setText("粉丝数："+up.fan)
        upimage.setImageResource(up.image)
        binding.Debutton.setOnClickListener {
            val intent = Intent()
            Toast.makeText(this,"太弱小了，取关！",Toast.LENGTH_LONG).show()
            intent.putExtra("UpImformation",up)
            setResult(RESULT_OK,intent)
            finish()
        }
        binding.Debutton2.setOnClickListener {
            val intent = Intent()
            Toast.makeText(this,"这个彬彬就是逊啦",Toast.LENGTH_LONG).show()
            setResult(RESULT_CANCELED,intent)
            finish()
        }
/*
        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_detail)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

 */
    }
/*
    override fun onSupportNavigateUp(): Boolean {
    val navController = findNavController(R.id.nav_host_fragment_content_detail)
    return navController.navigateUp(appBarConfiguration)
            || super.onSupportNavigateUp()
    }
 */

}