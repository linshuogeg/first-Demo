package com.example.usercenterq.ui

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.lifecycle.LifecycleOwner
import com.example.mvpkt.view.BaseMVPActivity
import com.example.net.protocol.BaseRespEntity
import com.example.usercenter.model.protocol.resp.RespTypeEntity
import com.example.usercenterq.R
import com.example.usercenterq.contract.UserCenterContract
import com.example.usercenterq.presenter.UserCenterPresen5terImpl
import com.example.usercenterq.protocol.req.RespGoodEntity
import com.example.usercenterq.protocol.req.UserEntitiy
import kotlinx.android.synthetic.main.activity_login1.*

class LoginActivity1 : BaseMVPActivity<UserCenterPresen5terImpl>(),UserCenterContract.UserCenterView{
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
        return R.layout.activity_login1
    }

    override fun initEvent() {
        login.setOnClickListener {
            var username7=username456.text.trim().toString()
            var pwww=pwdd12.text.trim().toString()
            if (username456.text.toString().length<=0||pwdd12.text.toString().length<=0){
                showMsg("账号或者密码为空")
            }else{
                mPresenter.login(UserEntitiy("2021-01-01",0,pwww,"1",username7))
            }
        }

        toregister.setOnClickListener {
            val intent:Intent=Intent(this@LoginActivity1,LoginActivity::class.java)
            startActivity(intent)
        }
    }

    override fun releaseResource() {

    }

    override fun initData(savedInstanceState: Bundle?) {

    }

    override fun <T> registerSuccess(data: T) {
         showMsg("登录成功")
        jumpActivity(ZhuyeActivity::class.java)
    }

    override fun registerFailed(throwable: Throwable) {
        showMsg("登录失败，账号密码错误")
    }

    override fun getRecommendtypeSuccess(data: BaseRespEntity<List<RespTypeEntity>>) {

    }

    override fun getRecommendtypeFail(throwable: Throwable) {

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