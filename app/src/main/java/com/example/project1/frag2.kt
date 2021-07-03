package com.example.project1

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

class frag2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val STORAGE_PERMISSION = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        val STORAGE_PERMISSION_REQUEST = 200
        val ct = requireContext()

        fun checkPermission(permissions: Array<String>, permissionRequestNumber:Int){
            val permissionResult = ContextCompat.checkSelfPermission(ct, permissions[0])
            when(permissionResult){
                PackageManager.PERMISSION_GRANTED -> {

                }
                PackageManager.PERMISSION_DENIED -> {
                    ActivityCompat.requestPermissions(requireActivity(), permissions, permissionRequestNumber)
                }
            }
        }

        checkPermission(STORAGE_PERMISSION, STORAGE_PERMISSION_REQUEST)


        var modalList = ArrayList<Modal>()

        var names = arrayOf(
            "image1",
            "image2",
            "image3",
            "image4",
            "image5",
            "image6",
            "image7",
            "image8",
            "image9",
            "image10",
            "image11",
            "image12",
        )

        var images = intArrayOf(R.drawable.sample_images_01,
            R.drawable.sample_images_02,
            R.drawable.sample_images_03,
            R.drawable.sample_images_04,
            R.drawable.sample_images_05,
            R.drawable.sample_images_06,
            R.drawable.sample_images_07,
            R.drawable.sample_images_08,
            R.drawable.sample_images_09,
            R.drawable.sample_images_10,
            R.drawable.sample_images_11,
            R.drawable.sample_images_12,)

        // Inflate the layout for this fragment
        for(i in names.indices){
            modalList.add(Modal(names[i],images[i]))
        }

        var view = inflater.inflate(R.layout.fragment_frag2, container, false)
        var customAdapter = frag2.CustomAdapter(modalList, ct);
        var gridView = view.findViewById<GridView>(R.id.gridView);
        gridView.adapter = customAdapter;

        gridView.setOnItemClickListener { adapterView, view, i, l ->
            var intent = Intent(requireContext(), ViewActivity::class.java)
            intent.putExtra("data", modalList[i])
            startActivity(intent);
        }

        return view
    }

    internal fun newInstant() : frag2
    {
        val args = Bundle()
        val frag = frag2()
        frag.arguments = args
        return frag
    }

    class CustomAdapter(
        var itemModel: ArrayList<Modal>,
        var context: Context
    ) : BaseAdapter(){

        var layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        override fun getCount(): Int {
            return itemModel.size
        }

        override fun getItem(p0: Int): Any {
            return itemModel[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
            var view = view;
            if(view==null){
                view = layoutInflater.inflate(R.layout.row_items,viewGroup,false);
            }

            var imageView = view?.findViewById<ImageView>(R.id.imageView);
            imageView?.setImageResource(itemModel[position].image!!)

            return view!!;
        }

    }

}