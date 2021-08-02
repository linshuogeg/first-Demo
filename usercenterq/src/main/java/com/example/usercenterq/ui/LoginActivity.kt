package com.example.usercenterq.ui
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner

import com.example.common.sp.SPProDelegate
import com.example.mvpkt.view.BaseMVPActivity
import com.example.net.protocol.BaseRespEntity
import com.example.usercenter.model.protocol.resp.RespTypeEntity
import com.example.usercenterq.R


import com.example.usercenterq.contract.UserCenterContract
import com.example.usercenterq.presenter.UserCenterPresen5terImpl
import com.example.usercenterq.protocol.req.RespGoodEntity
import com.example.usercenterq.protocol.req.UserEntitiy
import kotlinx.android.synthetic.main.activity_login.*
import java.util.*
class LoginActivity : BaseMVPActivity<UserCenterPresen5terImpl>(), UserCenterContract.UserCenterView{
    var a:Int=0
    var time:Int=60
    private var username:String by SPProDelegate<String>("username","testuser")
    override fun createPresenter(): UserCenterPresen5terImpl {
        return UserCenterPresen5terImpl(this)
    }
    override fun getLayoutID(): Int {
        val window: Window = window
        val decorView: View = window.getDecorView()
        val option = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
        decorView.systemUiVisibility = option
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.setStatusBarColor(Color.TRANSPARENT)
        }
           return R.layout.activity_login
    }

    override fun initEvent() {
       aaa.setOnClickListener {
           var userName:String=username2123.text.trim().toString()
           var pwd=password.text.trim().toString()
           mPresenter.register(UserEntitiy("2021-01-01",0,pwd,"1",userName))



       }
        yan.setOnClickListener {
            Log.i("asdadada", "initEvent: ")
            val timer=Timer()
            timer.schedule(object :TimerTask(){
                override fun run() {
                    if (time>0){
                        time--
                        runOnUiThread{
                            yan.text=time.toString()
                        }
                    }
                }
            },0,1000)
        }


    }

    override fun releaseResource() {
    }

    override fun initData(savedInstanceState: Bundle?) {
    }

    override fun <T> registerSuccess(data: T) {
        showMsg("注册成功")
        startActivity(Intent(this,LoginActivity1::class.java))
    }

    override fun registerFailed(throwable: Throwable) {
        Log.e("TAG", "registerFailed: "+ throwable.message )
        showMsg("注册失败")
    }

    override fun getRecommendtypeSuccess(data: BaseRespEntity<List<RespTypeEntity>>) {
        TODO("Not yet implemented")
    }

    override fun getRecommendtypeFail(throwable: Throwable) {
        TODO("Not yet implemented")
    }

    override fun registerFaild(e: Throwable) {
        TODO("Not yet implemented")
    }

    override fun requestTB(data: RespGoodEntity) {
        TODO("Not yet implemented")
    }

    override fun getLifecycleOwner(): LifecycleOwner {
        return this
    }

}


