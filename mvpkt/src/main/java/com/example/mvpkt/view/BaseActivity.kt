package com.example.mvpkt.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mvpkt.common.ConstValue

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutID())
        initData(savedInstanceState)
        initEvent()

        if (isClearStatBar()){
            ClearStatBar()
        }

    }

    fun jumpActivity(otherActivity:Class<*>){
        startActivity(Intent(this@BaseActivity,otherActivity))
    }

    fun jumpActivity(otherActivity: Class<*>,params:Bundle?){
        val intent:Intent= Intent(this@BaseActivity,otherActivity)
        intent.putExtra(ConstValue.JUMP_ACTIVITY_PARAMS_KEY,params)
        startActivity(intent)
    }


    fun showMsg(msg:String){
        Toast.makeText(this@BaseActivity, msg, Toast.LENGTH_SHORT).show()
    }

    protected open fun isClearStatBar():Boolean{
        return true
    }

    fun ClearStatBar(){

    }

    override fun onStop() {
        super.onStop()
//        releaseResource()
    }

    abstract fun getLayoutID():Int


    abstract fun initEvent()

    abstract fun releaseResource()

    abstract fun initData(savedInstanceState: Bundle?)
}