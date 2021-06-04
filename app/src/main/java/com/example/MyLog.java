package com.example;

import android.util.Log;

/**
 * Author: ruiduan
 * Date:  2021/6/5 1:21
 * Desc:
 */
public class MyLog {

    public static void e(Object obj) {
        Log.e(obj.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[3].getMethodName());
    }

    public static void i(Object obj) {
        Log.e(obj.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[3].getMethodName());
    }
}
