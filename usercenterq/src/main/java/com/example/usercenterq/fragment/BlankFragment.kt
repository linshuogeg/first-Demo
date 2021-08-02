package com.example.usercenterq.fragment
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.common.App.MyApplication
import com.example.mvpkt.view.BaseMvoFragment
import com.example.net.protocol.BaseRespEntity
import com.example.usercenter.adapter.TypeAdapter
import com.example.usercenter.model.protocol.resp.RespTypeEntity
import com.example.usercenterq.ui.MainActivity23
import com.example.usercenterq.R
import com.example.usercenterq.adapter.MyadaPterss
import com.example.usercenterq.contract.UserCenterContract
import com.example.usercenterq.presenter.UserCenterPresen5terImpl
import com.example.usercenterq.protocol.req.BannerEntity
import com.example.usercenterq.protocol.req.RespGoodEntity
import com.google.gson.Gson
import com.lzy.okgo.OkGo
import com.lzy.okgo.callback.StringCallback
import com.lzy.okgo.model.Response
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import kotlinx.android.synthetic.main.fragment_blank.*
class BlankFragment( ) : BaseMvoFragment<UserCenterPresen5terImpl>(), UserCenterContract.UserCenterView  {
    override fun createPresentrer(): UserCenterPresen5terImpl {
        return UserCenterPresen5terImpl(this)
    }
    override fun initEvent() {
        sousuo.setOnClickListener {
            val intent: Intent = Intent(MyApplication.getAppContext(), MainActivity23::class.java)
            startActivity(intent)
        }
        OkGo.get<String>("http://vueshop.glbuys.com/api/home/index/slide?token=1ec949a15fb709370f")
            .execute(object : StringCallback() {
                override fun onSuccess(response: Response<String>) {
                    val s = response.body()
                    val gson = Gson()
                    val bannerEntity = gson.fromJson(s, BannerEntity::class.java)
                    val data  = bannerEntity.getData()
                    banner.addBannerLifecycleObserver(this@BlankFragment)
                        .setAdapter(object :BannerImageAdapter<BannerEntity.DataBean>(data){
                            override fun onBindView(
                                holder: BannerImageHolder?,
                                data: BannerEntity.DataBean?,
                                position: Int,
                                size: Int
                            ) {
                                Glide.with(holder!!.itemView).load("http://"+data!!.image).into(holder.imageView)
                            }
                        })
                }
            })
        banner.start()
    }
    override fun initData(savedInstanceState: Bundle?) {
        mPresener.getRecommendtype()
        mPresener.requestTB(1)
    }
    override fun ClearStatBar() {
    }
    override fun getLayoutId(): Int {
//        val window: Window = window
//        val decorView: View = window.getDecorView()
//        val option = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
//        decorView.systemUiVisibility = option
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
//            window.setStatusBarColor(Color.TRANSPARENT)
//        }
       return R.layout.fragment_blank
    }
    override fun releaseResource() {

    }
    override fun <T> registerSuccess(data: T) {

    }
    override fun registerFailed(throwable: Throwable) {

    }
    override fun getRecommendtypeSuccess(data: BaseRespEntity<List<RespTypeEntity>>) {
        var data1 = data.data
           rvv1.layoutManager=GridLayoutManager(context,2,GridLayoutManager.HORIZONTAL,false)
           rvv1.adapter=TypeAdapter(data1)
    }
    override fun getRecommendtypeFail(throwable: Throwable) {

    }
    override fun registerFaild(e: Throwable) {
    }
    override fun requestTB(data: RespGoodEntity) {
        var data2=data.data
        rvv3.layoutManager=GridLayoutManager(context,2,GridLayoutManager.VERTICAL,false)
        rvv3.adapter=MyadaPterss(data2)
    }
    override fun getLifecycleOwner(): LifecycleOwner {
       return this
    }



}