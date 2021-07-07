package com.example.project1

import android.app.PendingIntent
import android.app.PendingIntent.CanceledException
import android.app.Service
import android.content.Intent
import android.content.ServiceConnection
import android.graphics.PixelFormat
import android.os.Build
import android.os.IBinder
import android.view.*
import android.widget.Button
import android.widget.TextView

class AlarmService : Service() {
    var wm: WindowManager? = null
    var mView: View? = null
    override fun onBind(intent: Intent): IBinder? {
        return null
    }


    override fun onCreate() {
        super.onCreate()
        val li = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        wm = getSystemService(WINDOW_SERVICE) as WindowManager
        val LAYOUT_FLAG: Int
        LAYOUT_FLAG = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
        } else {
            WindowManager.LayoutParams.TYPE_PHONE
        }
        val params = WindowManager.LayoutParams(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT,
            LAYOUT_FLAG,
            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
            PixelFormat.TRANSLUCENT
        )
        params.gravity = Gravity.LEFT or Gravity.TOP
        mView = li.inflate(R.layout.moveback, null)
        wm?.addView(mView, params)
        val bt = mView?.findViewById<Button>(R.id.returnback)

        bt?.setOnClickListener {
            onDestroy()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        if (wm != null) {
            if (mView != null) {
                wm!!.removeView(mView)
                mView = null
            }
            wm = null
            val intent = Intent(this, DestinationActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
            try {
                pendingIntent.send()
            } catch (e: CanceledException) {
                e.printStackTrace()
            }
        }
    }


    override fun unbindService(conn: ServiceConnection) {
        super.unbindService(conn)
        onDestroy()
    }
}