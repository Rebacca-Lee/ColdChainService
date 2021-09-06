package com.honeywell.coldchainservice

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.util.Log

/**
 * An [IntentService] subclass for handling asynchronous task requests in
 * a service on a separate handler thread.

 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.

 */
class MonitorTempIntentService : IntentService("MonitorTempIntentService") {

    override fun onHandleIntent(intent: Intent?) {
        Log.i(TAG,"Thread id is ${Thread.currentThread().name}")
        when (intent?.action) {

            ACTION_START_TEMP_MONITOR -> {
                handleActionStart()
            }
        }
    }

    /**
     * Handle action ACTION_START_TEMP_MONITOR in the provided background thread with the provided
     * parameters.
     */
    private fun handleActionStart() {
        Log.i(TAG,"handleActionStart")
    }



    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"onDestory executed")
    }

    companion object {
        /**
         * Starts this service to perform action ACTION_START_TEMP_MONITOR with the given parameters. If
         * the service is already performing a task this action will be queued.
         *
         * @see IntentService
         */
        @JvmStatic
        fun handleActionStart(context: Context) {
            val intent = Intent(context, MonitorTempIntentService::class.java).apply {
                action = ACTION_START_TEMP_MONITOR
            }
            context.startService(intent)
        }
    }
}