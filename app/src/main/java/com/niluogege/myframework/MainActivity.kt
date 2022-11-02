package com.niluogege.myframework

import android.app.Activity
import android.content.Intent
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.niluogege.myframework.debug.DebugNodeListActivity

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById(R.id.to_debug_node_list).setOnClickListener {
            val intent = Intent(this, DebugNodeListActivity::class.java)
//            startActivity(intent)
            startActivityForResult(intent,100)
        }
    }


    override fun onPause() {
        super.onPause()
        Log.e("MainActivity111","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("MainActivity111","onStop")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.e("MainActivity111","onActivityResult")

    }
}