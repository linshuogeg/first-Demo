package com.example.mvpkt

abstract class BaseRepository <M :IModel> {

    protected lateinit var mModel:M
    init {
        mModel=creatrModel()
    }

    abstract fun creatrModel():M
}