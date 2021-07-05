package com.example.project1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class EasterEgg : AppCompatActivity() {

    var url:String = "file:///android_asset/index.html"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_easter_egg)

        supportActionBar?.setTitle("Easter Egg")

        var webView:WebView=findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true
        webView.loadUrl(url)
    }
}