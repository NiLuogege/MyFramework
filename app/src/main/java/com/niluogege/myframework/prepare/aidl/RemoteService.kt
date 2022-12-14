package com.niluogege.myframework.prepare.aidl

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.niluogege.myframework.utils.Log

class RemoteService : Service() {
    companion object{
        const val TAG = "RemoteService"
    }


    override fun onCreate() {
        super.onCreate()
        Log.e(TAG,"onCreate")
    }

    override fun onBind(intent: Intent): IBinder {
        Log.e(TAG,"onBind")
        return service
    }

    override fun onRebind(intent: Intent?) {
        Log.e(TAG,"onRebind")
        super.onRebind(intent)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e(TAG,"onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.e(TAG,"onUnbind")
        return true
    }

    private val service = object : IAidlInterface.Stub() {
        override fun basicTypes(
            anInt: Int,
            aLong: Long,
            aBoolean: Boolean,
            aFloat: Float,
            aDouble: Double,
            aString: String?
        ): String {
            return "Int=$anInt Long=$aLong Boolean=$aBoolean Float=$aFloat Double=$aDouble String=$aString "
        }

        override fun method2() {
            println("dfaasdfsd")
        }


    }
}