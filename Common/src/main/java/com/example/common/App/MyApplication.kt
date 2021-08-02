package com.example.common.App

import android.app.Activity
import android.app.Application
import android.content.Context

class MyApplication : Application() {
    lateinit var acitivies:MutableList<Activity>

    init {

    }

    override fun onCreate() {
        super.onCreate()
        mContext=this
    }
    companion object{
        var mContext:Application?=null
        fun getAppContext(): Context {
            return mContext!!
        }
    }

}