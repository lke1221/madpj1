package com.example.project1

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService
import java.text.SimpleDateFormat
import java.util.*

class AlarmReceiver : BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {

        val i = Intent(context,DestinationActivity::class.java)
        intent!!.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(context, 0, i, 0)

        val calendar: Calendar = Calendar.getInstance()
        val formatDate: SimpleDateFormat = SimpleDateFormat("EEEE, MMMM d, yyyy", Locale.KOREA)
        val formatTime: SimpleDateFormat = SimpleDateFormat("HH:mm", Locale.KOREA)
        val date = formatDate.format(calendar.time)
        val time = formatTime.format(calendar.time)

        val builder = NotificationCompat.Builder(context!!, "foxandroid")
            .setSmallIcon(R.drawable.notification_icon)
            .setContentTitle("기상")
            .setContentText("$time")
            .setAutoCancel(true)
            .setSilent(true)
            .setDefaults(NotificationCompat.DEFAULT_ALL)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)

        val notificationManager = NotificationManagerCompat.from(context)
        notificationManager.notify(123, builder.build())

        AlarmPlay.startAlarm(context)
        val mediaplayer = MediaPlayer.create(context, R.raw.music)
        mediaplayer.start()

    }


}