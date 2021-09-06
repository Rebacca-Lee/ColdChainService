package com.honeywell.coldchainservice


import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.os.Handler
import android.os.Message
import android.util.Log
import com.honeywell.coldchainservice.utils.FileUtil


class MonitorTempIntentService : IntentService("MonitorTempIntentService") {

    var mBatteryTemp : Int? = 0
    var mScannerTemp : Int? = 0

    public var fileUtil : FileUtil?= null

    val handler: Handler? = object : Handler(){

        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            var what = msg.what
            //switch case
            when(what){
                MESSAGE_READ_TEMPERATURE ->{
                    mBatteryTemp = fileUtil?.readTemperature(PATH_BATTERY_TEMP)
                    mScannerTemp = fileUtil?.readTemperature(PATH_SUPERCAP_TEMP)
                    Log.d(TAG,"mBatteryTemp = " + mBatteryTemp + ", mScannerTemp = " + mScannerTemp)
                    this.sendEmptyMessage(MESSAGE_READ_TEMPERATURE)
                }
            }
        }
    }

    override fun onHandleIntent(intent: Intent?) {
        Log.i(TAG,"Thread id is ${Thread.currentThread().name}")
        fileUtil = FileUtil()
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
        handler?.sendEmptyMessage(MESSAGE_READ_TEMPERATURE)
    }


    fun readTemperature(){

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