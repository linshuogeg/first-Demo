package com.example.mvpkt

import java.lang.ref.SoftReference

abstract class BasePresenter <Repo: BaseRepository<*>,V:IView>(_view:V) {

    protected lateinit var mRepository: Repo
    protected lateinit var mView:SoftReference<V>

    init {
        mRepository=createRepository()
        mView= SoftReference<V>(_view)
    }

    abstract fun createRepository():Repo
}