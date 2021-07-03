package com.example.project1

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.GridView
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pagerAdapter = FragmentAdapter(supportFragmentManager)
        val pager = findViewById<ViewPager>(R.id.viewPager)
        pager.adapter = pagerAdapter
        val tab = findViewById<TabLayout>(R.id.tab)
        tab.setupWithViewPager(pager)
    }




}