package com.example.project1

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager

class ViewActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        var modalItems: Modal = intent.getSerializableExtra("data") as Modal

        Log.e("name", modalItems.name!!)

        findViewById<ImageView>(R.id.viewImage).setImageResource(modalItems.image!!);
     }
}