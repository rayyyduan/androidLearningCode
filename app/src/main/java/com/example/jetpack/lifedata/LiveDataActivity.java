package com.example.jetpack.lifedata;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import com.example.activity.R;

/**
 * Author: ruiduan
 * Date:  2021/6/5 20:21
 * Desc:
 */
public class LiveDataActivity extends AppCompatActivity {
    MutableLiveData<String> mLiveData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.empty_layout);
        mLiveData = new MutableLiveData<>();
        mLiveData.observe(this, s -> Log.w("LiveData onChanged:", s));
        log("onCreate");//activity是非活跃状态，不会回调onChanged。变为活跃时，value被onStart中的value覆盖
    }

    @Override
    protected void onStart() {
        super.onStart();
        log("onStart: ");//活跃状态，会回调onChanged。并且value会覆盖onCreate、onStop中设置的value
    }
    @Override
    protected void onResume() {
        super.onResume();
        log("onResume: ");//活跃状态，回调onChanged
    }
    @Override
    protected void onPause() {
        super.onPause();
        log("onPause: ");//活跃状态，回调onChanged
    }
    @Override
    protected void onStop() {
        super.onStop();
        log("onStop: ");//非活跃状态，不会回调onChanged。后面变为活跃时，value被onStart中的value覆盖
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        log("onDestroy: ");//非活跃状态，且此时Observer已被移除，不会回调onChanged
    }

    protected void log(String str) {
        Log.e("Activity onChanged:", str);
        mLiveData.setValue(str);
    }
}