package com.example.project1

import android.Manifest
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.project1.databinding.ActivityMainBinding

class addContact : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val TAG = "CONTACT_ADD_TAG"

    private lateinit var contactPermission: Array<String>
    private val WRITE_CONTACT_PERMISSION_CODE = 100
    private val IMAGE_PICK_GALLERY_CODE = 200
    private val image_uri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_contact)


        contactPermission = arrayOf(Manifest.permission.WRITE_CONTACTS)
        findViewById<ImageView>(R.id.profileIv).setOnClickListener {

        }
















        /*finish()*/


    }
}