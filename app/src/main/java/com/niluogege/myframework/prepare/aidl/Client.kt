package com.niluogege.myframework.prepare.aidl

import android.app.Activity
import android.content.ComponentName
import android.content.ServiceConnection
import android.os.IBinder
import com.niluogege.myframework.utils.Log
import android.content.Intent

import android.R.attr.name
import android.content.Context


class Client {
    companion object {
        const val TAG = "Client"
    }

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            Log.e(TAG, "onServiceConnected ComponentName=$name IBinder=$service")

            val binderProxy = IAidlInterface.Stub.asInterface(service)
            val result = binderProxy.basicTypes(1, 2, true, 3.0f, 4.0, "hhh")
            Log.e(TAG, "result=$result")
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            Log.e(TAG, "onServiceDisconnected ComponentName=$name")
        }

    }


    //绑定 启动 远程服务
    fun bindRemoteService(activity: Activity) {
        val intent = Intent()
        //需要和 manifast中配置的一样
        intent.action = "com.niluogege.remoteService"
        //Service包名 这里的包名是APP包名不是类的包名
        intent.setPackage("com.niluogege.myframework")
        activity.bindService(intent, connection, Context.BIND_AUTO_CREATE)
    }

    //解绑服务
    fun unBindRemoteService(activity: Activity){
        activity.unbindService(connection)
    }
}