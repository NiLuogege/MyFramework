package com.niluogege.myframework.debug

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import android.os.Bundle
import android.os.IBinder
import android.widget.TextView
import com.niluogege.myframework.R
import com.niluogege.myframework.prepare.binder.BinderService
import com.niluogege.myframework.prepare.binder.utils
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


        //注入自定义SystemService
        findViewById(R.id.btn_add_custom_system_service).setOnClickListener {
            utils.regist()
        }

    }
}