package com.example.project1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView

class frag3 : Fragment() {

    var url:String = "file:///android_asset/index.html"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_frag3, container, false)
        var webView = view.findViewById<WebView>(R.id.webView)
        webView.settings.javaScriptEnabled = true
        webView.loadUrl(url)

        return view
    }

    internal fun newInstant() : frag3
    {
        val args = Bundle()
        val frag = frag3()
        frag.arguments = args
        return frag
    }
}