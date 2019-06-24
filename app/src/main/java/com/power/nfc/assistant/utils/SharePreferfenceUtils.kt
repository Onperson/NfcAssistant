package com.power.nfc.assistant.utils

import android.content.Context
import android.content.SharedPreferences
import java.security.AccessControlContext

class SharePreferfenceUtils {



    private constructor()

    companion object{
        private var INSTANCE: SharePreferfenceUtils? = null
        private var mEditor: SharedPreferences.Editor? = null
        private var mSharedPreferences: SharedPreferences? = null

        fun getSpUtilsInstance(context: Context): SharePreferfenceUtils?{
            if(INSTANCE == null){
                synchronized(SharePreferfenceUtils::class.java){
                    if(INSTANCE == null){
                        INSTANCE = SharePreferfenceUtils()
                        mSharedPreferences = context.getSharedPreferences("nfc_assistant_sp", Context.MODE_PRIVATE)
                        mEditor = mSharedPreferences?.edit()
                    }
                }
            }
            return  INSTANCE
        }
    }

    fun saveStringValue(key: String,value: String?){
        mEditor?.putString(key,value)
        mEditor?.commit()
    }
    fun getStringValue(key: String,defaultValue: String): String?{
        return mSharedPreferences?.getString(key,defaultValue)
    }
}