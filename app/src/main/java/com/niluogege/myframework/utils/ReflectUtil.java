/*
 * Tencent is pleased to support the open source community by making wechat-matrix available.
 * Copyright (C) 2018 THL A29 Limited, a Tencent company. All rights reserved.
 * Licensed under the BSD 3-Clause License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://opensource.org/licenses/BSD-3-Clause
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.niluogege.myframework.utils;


import java.lang.reflect.Field;
import java.lang.reflect.Method;


public final class ReflectUtil {


    private ReflectUtil() {
        throw new UnsupportedOperationException();
    }


    public static <T> T get(Class<?> clazz, String fieldName) throws Exception {
        return new ReflectFiled<T>(clazz, fieldName).get();
    }

    public static <T> T get(Class<?> clazz, String fieldName, Object instance) throws Exception {
        return new ReflectFiled<T>(clazz, fieldName).get(instance);
    }

    public static boolean set(Class<?> clazz, String fieldName, Object object) throws Exception {
        return new ReflectFiled(clazz, fieldName).set(object);
    }

    public static boolean set(Class<?> clazz, String fieldName, Object instance, Object value) throws Exception {
        return new ReflectFiled(clazz, fieldName).set(instance, value);
    }

    public static <T> T invoke(Class<?> clazz, String methodName, Object instance, Object... args) throws Exception {
        return new ReflectMethod(clazz, methodName).invoke(instance, args);
    }


    public static Field getDeclaredFieldRecursive(Object clazz, String fieldName) throws NoSuchFieldException, ClassNotFoundException {
        Class<?> realClazz = null;
        if (clazz instanceof String) {
            realClazz = Class.forName((String) clazz);
        } else if (clazz instanceof Class) {
            realClazz = (Class<?>) clazz;
        } else {
            throw new IllegalArgumentException("Illegal clazz type: " + clazz.getClass());
        }
        Class<?> currClazz = realClazz;
        while (true) {
            try {
                Field field = currClazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                return field;
            } catch (NoSuchFieldException e) {
                if (currClazz.equals(Object.class)) {
                    throw e;
                }
                currClazz = currClazz.getSuperclass();
            }
        }
    }

    public static Method getDeclaredMethodRecursive(Object clazz, String methodName, Class<?>... argTypes) throws NoSuchMethodException, ClassNotFoundException {
        Class<?> realClazz = null;
        if (clazz instanceof String) {
            realClazz = Class.forName((String) clazz);
        } else if (clazz instanceof Class) {
            realClazz = (Class<?>) clazz;
        } else {
            throw new IllegalArgumentException("Illegal clazz type: " + clazz.getClass());
        }
        Class<?> currClazz = realClazz;
        while (true) {
            try {
                Method method = currClazz.getDeclaredMethod(methodName,argTypes);
                method.setAccessible(true);
                return method;
            } catch (NoSuchMethodException e) {
                if (currClazz.equals(Object.class)) {
                    throw e;
                }
                currClazz = currClazz.getSuperclass();
            }
        }
    }


    public static  <T> T reflectObject(Object instance, String name) {
        try {
            Field field = instance.getClass().getDeclaredField(name);
            field.setAccessible(true);
            return (T) field.get(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
