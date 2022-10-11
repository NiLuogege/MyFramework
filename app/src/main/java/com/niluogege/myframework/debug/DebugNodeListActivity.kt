package com.niluogege.myframework.debug

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.IBinder
import android.widget.TextView
import android.widget.Toast
import com.niluogege.myframework.R
import com.niluogege.myframework.prepare.aidl.Client
import com.niluogege.myframework.prepare.aidl.IAidlInterface
import com.niluogege.myframework.prepare.binder.BinderService
import com.niluogege.myframework.prepare.binder.utils
import com.niluogege.myframework.utils.Log
import com.niluogege.myframework.utils.ReflectMethod
import com.niluogege.myframework.utils.ReflectUtil

//用于记录各个知识点的 类
class DebugNodeListActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_debug_node_list)

        //获取服务流程
        findViewById(R.id.btn_get_system_service).setOnClickListener {
            val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            println("aa=${activityManager.appTasks}")
        }

        //startService
        findViewById(R.id.btn_start_service).setOnClickListener {
            val intent = Intent()
            //需要和 manifast中配置的一样
            intent.action = "com.niluogege.remoteService"
            //Service包名 这里的包名是APP包名不是类的包名
            intent.setPackage("com.niluogege.myframework")
            startService(intent)
        }

        //bindService
        findViewById(R.id.btn_bind_service).setOnClickListener {
            Client.bindRemoteService(this)
        }


        //unbindService
        findViewById(R.id.btn_un_bind_service).setOnClickListener {
            Client.unBindRemoteService(this)
        }


        //btn_sm_add_serivce
        findViewById(R.id.btn_sm_add_serivce).setOnClickListener {

            Toast.makeText(this,"系统不允许反射调用addService，回报安全异常，所以framework 只能通过 bindService的方式来使用Binder",Toast.LENGTH_LONG).show()

//            val intent = Intent()
//            //需要和 manifast中配置的一样
//            intent.action = "com.niluogege.remoteByNameService"
//            //Service包名 这里的包名是APP包名不是类的包名
//            intent.setPackage("com.niluogege.myframework")
//            startService(intent)
        }

        //btn_sm_get_serivce
        findViewById(R.id.btn_sm_get_serivce).setOnClickListener {
            Toast.makeText(this,"系统不允许反射调用addService，回报安全异常，所以framework 只能通过 bindService的方式来使用Binder",Toast.LENGTH_LONG).show()

//            val me =ReflectUtil.getDeclaredMethodRecursive(Class.forName("android.os.ServiceManager"),"getService",String::class.java)
//           val iBinder = me.invoke(null,"luochenRemoteByNameService") as IBinder
//            val binderProxy = IAidlInterface.Stub.asInterface(iBinder)
//            val result = binderProxy.basicTypes(1, 2, true, 3.0f, 4.0, "hhh")
//            Log.e(Client.TAG, "result=$result")
        }


        findViewById(R.id.btn_sm_get_serivce).setOnClickListener {
           //反射 Process.start方法 应该是可以的。
        }


    }
}