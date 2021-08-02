package com.example.mvpkt.view

import com.example.mvpkt.BasePresenter

abstract class BaseMVPActivity <P:BasePresenter<*,*>>: BaseActivity() {
    protected lateinit var mPresenter:P
    init {
        mPresenter=createPresenter()
    }
    abstract fun createPresenter():P
}