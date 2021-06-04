package com.example.jetpack;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.example.activity.R;

/**
 * Author: ruiduan
 * Date:  2021/6/2 22:21
 * Desc:  lifecycle
 */
public class LifeCycleActivity extends AppCompatActivity {

    private static final String TAG = "LifeCycleActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lifecycle);
        getLifecycle().addObserver(new MyLifeCycyleObserver());
        Log.i(TAG, "onCreate");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");

    }
}

class MyLifeCycyleObserver implements LifecycleObserver {
    private static final String TAG = "MyLifeCycyleObserver";

    @OnLifecycleEvent(value = Lifecycle.Event.ON_RESUME)
    public void lifeCycleResume() {
        Log.e(TAG, "onResume");
    }

    @OnLifecycleEvent(value = Lifecycle.Event.ON_CREATE)
    public void lifeCycleCreate() {
        Log.e(TAG, "onCreate");
    }

    @OnLifecycleEvent(value = Lifecycle.Event.ON_PAUSE)
    public void lifeCyclePause() {
        Log.e(TAG, "onPause");
    }





}
