package com.honeywell.coldchainservice

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MonitorService : Service() {

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG,"the current thread id is ${Thread.currentThread().name}")
        when (intent?.action){
            ACTION_START_TEMP_MONITOR->{

            }
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy executed.")
    }

}