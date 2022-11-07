package com.niluogege.myframework

import android.app.Activity
import android.content.Intent
import android.os.Bundle

/**
 * 用于验证 启动窗口问题
 */
class StartActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_MyFramework)
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}