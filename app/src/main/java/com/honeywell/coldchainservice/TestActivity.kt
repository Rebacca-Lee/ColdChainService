package com.honeywell.coldchainservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        Log.d(TAG,"onCreate executed")
        var intent = Intent(this, MonitorTempIntentService::class.java)
        intent.setAction(ACTION_START_TEMP_MONITOR)
        this.startService(intent)
    }
}