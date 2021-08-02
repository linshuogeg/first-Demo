package com.example.common.sp

import android.content.Context
import android.content.SharedPreferences
import com.example.common.App.MyApplication

object SPutils {

    private val sp:SharedPreferences by lazy {
        creteSharedPreferences()
    }

    private fun creteSharedPreferences():SharedPreferences{
        return MyApplication.getAppContext().getSharedPreferences("ls1912", Context.MODE_PRIVATE)
    }
  //向SP中存值
    fun <T> putValue(key:String,value:T,isCommit:Boolean){
         sp.edit().apply(){
             when(value){
                 is String->putString(key,value)
                 is Float->putFloat(key, value)
                 is Boolean->putBoolean(key, value)
                 is Long->putLong(key, value)
                 is Int->putInt(key, value)
                 else->throw IllegalArgumentException("unknown")


             }
             if (isCommit)commit()else apply()
         }

    }

    fun <T> getValue(key: String,defaultValue:T):T {
        return when(defaultValue){
            is String-> sp.getString(key,defaultValue)
            is Float-> sp.getFloat(key,defaultValue)
            is Boolean->sp.getBoolean(key,defaultValue)
            is Long-> sp.getLong(key,defaultValue)
            is Int->sp.getInt(key,defaultValue)
            else -> throw IllegalArgumentException("unknow")
        }as T
    }

}