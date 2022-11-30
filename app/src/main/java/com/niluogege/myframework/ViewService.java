package com.niluogege.myframework;

import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.niluogege.myframework.utils.LogUtils;

/**
 * 将view在 service中显示出来
 *
 * 想正常显示的话需要 申请权限。目前没有需要手动赋予
 *   */
public class ViewService extends Service {


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.log("ViewService onCreate");


        View view  =LayoutInflater.from(this).inflate(R.layout.activity_parent,null);
        WindowManager.LayoutParams  lp = new WindowManager.LayoutParams();
        lp.type=WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        windowManager.addView(view,lp);

    }


}
