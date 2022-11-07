package com.niluogege.myframework

import android.app.Application

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        Thread.sleep(2000)

    }
}