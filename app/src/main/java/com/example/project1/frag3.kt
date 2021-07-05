package com.example.project1

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class frag3 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_frag3, container, false)
        view.findViewById<FloatingActionButton>(R.id.easter_egg).setOnClickListener {
            val intent = Intent(requireActivity(), EasterEgg::class.java)
            startActivity(intent)
        }

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