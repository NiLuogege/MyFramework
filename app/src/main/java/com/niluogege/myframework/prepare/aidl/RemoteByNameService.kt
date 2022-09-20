package com.niluogege.myframework.prepare.aidl

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.niluogege.myframework.utils.Log
import com.niluogege.myframework.utils.ReflectUtil

class RemoteByNameService : Service() {
    companion object{
        const val TAG = "RemoteByNameService"
    }


    override fun onCreate() {
        super.onCreate()
        Log.e(TAG,"onCreate")
        val me =ReflectUtil.getDeclaredMethodRecursive(Class.forName("android.os.ServiceManager"),"addService",String::class.java,IBinder::class.java)
        me.invoke(null,"luochenRemoteByNameService",service)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e(TAG,"onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): IBinder? {
        Log.e(RemoteService.TAG,"onBind")
        return null
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