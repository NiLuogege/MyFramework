package com.niluogege.myframework

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import com.niluogege.myframework.debug.DebugNodeListActivity

class ParentActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parent)
    }
}