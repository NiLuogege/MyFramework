package com.niluogege.myframework

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import com.niluogege.myframework.debug.DebugNodeListActivity

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById(R.id.to_debug_node_list).setOnClickListener {
            val intent = Intent(this, DebugNodeListActivity::class.java)
            startActivity(intent)
        }
    }
}