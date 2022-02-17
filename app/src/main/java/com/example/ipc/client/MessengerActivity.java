package com.example.ipc.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.example.C;
import com.example.activity.R;
import com.example.ipc.service.MessengerService;

public class MessengerActivity extends AppCompatActivity {
    private static final String TAG = MessengerActivity.class.getSimpleName();

    private final Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case MessengerService.MSG_FROM_CLIENT:
                    Log.i(TAG, "收到发来的服务端信息-------" + msg.getData().get("rep"));
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.empty_layout);
        Intent intent = new Intent(MessengerActivity.this,MessengerService.class);
        intent.putExtra(C.DATA, "Intent can trans data");
        Log.i(TAG, "intent" + intent.hashCode());
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
    }

    private final ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Bundle mBundle = new Bundle();
            mBundle.putString("msg", "这里是客户端通过Messenger发送的消息");

            Messenger messenger = new Messenger(service);
            Message mMessage = Message.obtain(null,MessengerService.MSG_FROM_CLIENT);
            mMessage.setData(mBundle);
            mMessage.replyTo = new Messenger(mHandler);

            try {
                messenger.send(mMessage);
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