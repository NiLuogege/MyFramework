package com.niluogege.myframework

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.niluogege.myframework.debug.DebugNodeListActivity
import com.niluogege.myframework.utils.LogUtils

/**
 * 用于 测试 Activity的各种类回到
 *
 * 方法的顺序就是 回调的顺序
 */
class CallbackActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtils.log("onCreate ")
        setContentView(R.layout.activity_callback)
    }

    override fun onContentChanged() {
        super.onContentChanged()
        LogUtils.log("onContentChanged ---> setContentView的view被 填充（inflate） 以后会回调")
    }

    override fun onStart() {
        super.onStart()
        LogUtils.log("onStart")
    }


    override fun onResume() {
        super.onResume()
        LogUtils.log("onResume ---> view还不可见")
    }


    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        LogUtils.log("onAttachedToWindow ---> 绘制前会调用")
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        LogUtils.log("onWindowFocusChanged ---> view可见了 hasFocus=$hasFocus")
    }



    override fun onPause() {
        super.onPause()
        LogUtils.log("onPause")
    }

    override fun onStop() {
        super.onStop()
        LogUtils.log("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtils.log("onDestroy")
    }
}