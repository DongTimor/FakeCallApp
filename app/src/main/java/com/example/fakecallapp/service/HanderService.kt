package com.example.fakecallapp.service

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import com.example.fakecallapp.activity.CallActivity
import com.example.fakecallapp.activity.MainActivity

class HanderService : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Handler().postDelayed({
            // Tạo một Intent để mở Activity2
            val intent = Intent(this, CallActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        },3000)

        stopSelf()
        return super.onStartCommand(intent, flags, startId)
    }
}