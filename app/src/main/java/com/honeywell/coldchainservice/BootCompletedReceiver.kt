package com.honeywell.coldchainservice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.text.TextUtils
import android.util.Log

class BootCompletedReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        var action = intent.action
        if (TextUtils.isEmpty(action)) {
            return
        }
        if (TextUtils.equals(action, "android.intent.action.BOOT_COMPLETED")
            || TextUtils.equals(action, "com.honeywell.intent.action.BOOT_COMPLETED")
        ) {
            Log.d(TAG, "receiver : " + action)
            val intent = Intent(context, MonitorTempIntentService::class.java)
            intent.setAction(ACTION_START_TEMP_MONITOR)
            context.startService(intent)
        }
    }
}