package com.niluogege.myframework.prepare.binder

import android.os.Binder
import android.os.Parcel

class BinderService : Binder() ,I {
    override fun add(a: Int): Int {
        return a+1
    }

    override fun onTransact(code: Int, data: Parcel?, reply: Parcel?, flags: Int): Boolean {

        println("服务端onTransact")

        return super.onTransact(code, data, reply, flags)
    }
}