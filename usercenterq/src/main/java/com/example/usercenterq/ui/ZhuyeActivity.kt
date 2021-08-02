package com.example.usercenterq.ui

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.example.usercenterq.R
import com.example.usercenterq.adapter.FragmentAdapter
import com.example.usercenterq.fragment.*
import kotlinx.android.synthetic.main.activity_zhuye.*

class  ZhuyeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val window: Window = window
        val decorView: View = window.getDecorView()
        val option = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
        decorView.systemUiVisibility = option
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.setStatusBarColor(Color.TRANSPARENT)
        }
        setContentView(R.layout.activity_zhuye)
        var fragment:ArrayList<Fragment> = arrayListOf<Fragment>()
       fragment.add(BlankFragment())
        fragment.add(BlankFragment2())
        fragment.add(BlankFragment3())
        fragment.add(BlankFragment4())
        fragment.add(BlankFragment5())

        var biaoti:ArrayList<String> = arrayListOf<String>()
        biaoti.add("刷新")
        biaoti.add("分类")
        biaoti.add("发现")
        biaoti.add("购物车")
        biaoti.add("我的")

        var fragmentadapyter:FragmentAdapter= FragmentAdapter(supportFragmentManager,fragment,biaoti)
        vip.adapter=fragmentadapyter
        tab.setupWithViewPager(vip)
        tab.getTabAt(0)?.setIcon(R.mipmap.shuxin)
        tab.getTabAt(1)?.setIcon(R.mipmap.fenlei)
        tab.getTabAt(2)?.setIcon(R.mipmap.faxian)
        tab.getTabAt(3)?.setIcon(R.mipmap.gouwuhce)
        tab.getTabAt(4)?.setIcon(R.mipmap.wode)



    }
}