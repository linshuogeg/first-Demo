package com.example.common.sp

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class SPProDelegate <T>(
    private val key:String,
    private val defaultValue: T,
    private val isCommit:Boolean=true
        ):ReadWriteProperty<Any?,T> {
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        var finalKey=if (key.isNotBlank()) property.name else key
        return SPutils.getValue(finalKey,defaultValue)
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        SPutils.putValue(key,value,isCommit)
    }

}