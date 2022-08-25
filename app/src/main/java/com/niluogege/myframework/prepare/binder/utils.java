package com.niluogege.myframework.prepare.binder;

import android.os.IBinder;

import com.niluogege.myframework.utils.ReflectMethod;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class utils {
    public static void regist(){
        try {
            IBinder binderService = new BinderService();
            Class<?> aClass = Class.forName("android.os.ServiceManager");
            Method m =aClass.getMethod(
                    "addService",
                    String.class,
                    IBinder.class);

            m.setAccessible(true);
            m.invoke(null, "demoService", binderService);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
