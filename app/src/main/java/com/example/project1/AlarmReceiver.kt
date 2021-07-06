package com.example.project1

import android.app.PendingIntent
import android.app.PendingIntent.CanceledException
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import java.text.SimpleDateFormat
import java.util.*



class AlarmReceiver : BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {


        var intent = intent
        try {
            intent = Intent(context, DestinationActivity::class.java)
            val pi = PendingIntent.getActivity(
                context, 0, intent,
                PendingIntent.FLAG_ONE_SHOT
            )
            pi.send()
        } catch (e: CanceledException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        }

        //context?.startService(Intent(context, AlarmService::class.java))
        AlarmPlay.startAlarm(context!!)

    }


}