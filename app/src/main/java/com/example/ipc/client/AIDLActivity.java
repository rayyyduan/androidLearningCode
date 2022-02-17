package com.example.ipc.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.example.activity.IAIDLManager;
import com.example.activity.R;
import com.example.ipc.service.AIDLService;

/**
 * Author: ruiduan
 * Date:  2022/2/17 12:00
 * Desc:
 */
public class AIDLActivity extends AppCompatActivity {
    private static final String TAG = "AIDLActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.empty_layout);
        Intent mIntent=new Intent(AIDLActivity.this, AIDLService.class);
        bindService(mIntent, mServiceConnection, Context.BIND_AUTO_CREATE);
    }

    private final ServiceConnection mServiceConnection=new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            IAIDLManager aidl = IAIDLManager.Stub.asInterface(service);
            //返回Proxy对象 Proxy对象保存mRemote（远端binder），
            Log.i(TAG, "onServiceConnected: " + aidl.getClass().getSimpleName());
            try {
                aidl.setData("测试AIDL数据");

                Log.i(TAG, "onServiceConnected: AIDL getData " + aidl.getData());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(mServiceConnection);
    }
}
