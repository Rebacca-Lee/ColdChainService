package com.honeywell.coldchainservice

const val TAG = "ColdChainService"
const val PACKAGE_NAME = "com.honeywell.coldchainservice"

const val ACTION_START_TEMP_MONITOR = "com.honeywell.coldchainservice.action.START_TEMP_MONITOR"

//path:battery temp
const val PATH_BATTERY_TEMP = "/sys/class/power_supply/battery/temp"
//path:scanner temp
const val PATH_SUPERCAP_TEMP = "/sys/class/power_supply/supercap/temp"

const val INTERVAL = 1*1000;

const val MESSAGE_READ_TEMPERATURE = 0;
