package com.example.project1

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.graphics.scaleMatrix
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat

class frag3 : Fragment() {

    private lateinit var picker : MaterialTimePicker

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

        createNotificationChannel()

        view.findViewById<Button>(R.id.selectTimeBtn).setOnClickListener{

            showTimePicker(view)

        }
        view.findViewById<Button>(R.id.setAlarmBtn).setOnClickListener{

        }
        view.findViewById<Button>(R.id.cancelAlarmBtn).setOnClickListener{

        }

        return view
    }

    private fun showTimePicker(view: View) {
        picker = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_24H)
            .setHour(12)
            .setTitleText("Select Alarm Time")
            .build()

        picker.show(childFragmentManager, "foxandroid")
        picker.addOnPositiveButtonClickListener{
            if(picker.hour>12){
                view.findViewById<TextView>(R.id.selectedTime).setText(String.format("%02d", picker.hour-12)+":"+String.format("%02d", picker.minute)+"PM")
            }else{
                view.findViewById<TextView>(R.id.selectedTime).setText(String.format("%02d", picker.hour)+":"+String.format("%02d", picker.minute)+"AM")
            }
        }
        scaleMatrix()
    }

    private fun createNotificationChannel(){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val name:CharSequence = "foxandroidReminderChannel"
            val description = "Channel For Alarm Manager"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel("foxandroid", name, importance)
            channel.description = description
            val notificationManager = requireActivity().getSystemService(
                NotificationManager::class.java
            )

            notificationManager.createNotificationChannel(channel)
        }
    }

    internal fun newInstant() : frag3
    {
        val args = Bundle()
        val frag = frag3()
        frag.arguments = args
        return frag
    }
}