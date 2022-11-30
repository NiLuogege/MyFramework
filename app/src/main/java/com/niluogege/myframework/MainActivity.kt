package com.niluogege.myframework

import android.app.Activity
import android.content.Intent
import android.nfc.Tag
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.Choreographer
import android.widget.TextView
import com.niluogege.myframework.debug.DebugNodeListActivity

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById(R.id.to_debug_node_list).setOnClickListener {
            val intent = Intent(this, DebugNodeListActivity::class.java)
//            startActivity(intent)
            startActivityForResult(intent, 100)
        }


        findViewById(R.id.to_callback_activity).setOnClickListener {
            val intent = Intent(this, CallbackActivity::class.java)
            startActivity(intent)
        }

        val pttv = findViewById(R.id.pttv)
        findViewById(R.id.test_invalidate).setOnClickListener {
            pttv.invalidate()
        }
        findViewById(R.id.test_request_layout).setOnClickListener {
            pttv.requestLayout()
        }

        findViewById(R.id.start_view_service).setOnClickListener {
            startService(Intent(this, ViewService::class.java))
        }

//        testVsync()


    }

    private fun testVsync() {
        //这玩意儿运行在主线程，会阻塞主线程
        Choreographer.getInstance().postFrameCallback { frameTimeNanos ->
            Log.e("MainActivity111", "收到vsync信号了 frameTimeNanos->$frameTimeNanos")
            testVsync()
        }
    }


    override fun onPause() {
        super.onPause()
        Log.e("MainActivity111", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("MainActivity111", "onStop")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.e("MainActivity111", "onActivityResult")

    }
}