package com.example.mvpkt.view


import android.view.Window
import com.example.mvpkt.BasePresenter

abstract class BaseMvoFragment <P :BasePresenter<*,*>>: BaseFragment() {


    protected  lateinit  var mPresener:P
    init {
        mPresener=createPresentrer()
    }
    abstract fun createPresentrer():P

}