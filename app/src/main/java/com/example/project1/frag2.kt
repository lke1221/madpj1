package com.example.project1

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class frag2 : Fragment() {

    private var imageRecycler: RecyclerView?=null
    private var progressBar: ProgressBar?=null
    private var allPictures:ArrayList<Image>?=null
    /*private var temptext: TextView?=null*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_frag2, container, false)

        while(ContextCompat.checkSelfPermission(view.context, Manifest.permission.READ_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED){

        }

        imageRecycler=view.findViewById(R.id.image_recycler)
        progressBar=view.findViewById(R.id.recycler_progress)
        /*temptext=view.findViewById(R.id.text_view)*/

        imageRecycler?.layoutManager = GridLayoutManager(requireContext(), 3)
        imageRecycler?.setHasFixedSize(true)

        allPictures=ArrayList()

        if(allPictures!!.isEmpty()){
            progressBar?.visibility = View.VISIBLE
            allPictures=getAllImages()
            imageRecycler?.adapter=ImageAdapter(requireContext(),allPictures!!)
            /*temptext?.setText(allPictures!!.size.toString())*/
            progressBar?.visibility = View.GONE
        }

        return view
    }

    private fun getAllImages(): ArrayList<Image>? {
        val images=ArrayList<Image>()
        val allImageUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val projection = arrayOf(MediaStore.Images.ImageColumns.DATA, MediaStore.Images.Media.DISPLAY_NAME)
        var cursor = requireActivity().contentResolver.query(allImageUri, projection, null, null, null)

        try{
            cursor!!.moveToFirst()
            do{
                val image = Image(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)),
                    cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME)))
                images.add(image)
            }while(cursor.moveToNext())
            cursor.close()

        }catch(e:Exception)
        {
            e.printStackTrace()
        }
        return images
    }

    internal fun newInstant() : frag2
    {
        val args = Bundle()
        val frag = frag2()
        frag.arguments = args
        return frag
    }

}