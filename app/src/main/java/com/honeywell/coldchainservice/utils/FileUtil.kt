package com.honeywell.coldchainservice.utils

import android.text.TextUtils
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader

open class FileUtil {

    fun checkNode(path: String): Boolean {
        var file = File(path)
        return file.exists()
    }


    fun readTemperature(path: String): Int {
        if (TextUtils.isEmpty(path) || !checkNode(path)) {
            return -1
        }
        var fileInputStream = FileInputStream(File(path))
        var inputStreamReader = InputStreamReader(fileInputStream)
        var bufferedReader = BufferedReader(inputStreamReader)
        var line :String?=null
        var value :String?=null
        var stringBuilder = StringBuilder(4096)
        while ((bufferedReader.readLine().also { line = it })!= null){
            stringBuilder.append(line)
        }
        value = stringBuilder.toString().trim()
        if(!TextUtils.isEmpty(value)){
            return value.toInt();
        }
        return -1
    }

}