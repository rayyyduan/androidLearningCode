package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

public class MessengerService extends Service {
    public static final String TAG = MessengerService.class.getSimpleName();
    public static final int MSG_FROM_CLIENT = 1000;

    private final Handler mHandler = new Handler(Looper.getMainLooper()) {

        @Override
        public void handleMessage(Message msg) {
            if (msg.what == MSG_FROM_CLIENT) {
                Log.i(TAG, "收到客户端信息-------" + msg.getData().get("msg"));

                //通过client传过来的Messenger，给client返回消息
                Messenger mMessenger = msg.replyTo;
                Message mMessage = Message.obtain(null, MessengerService.MSG_FROM_CLIENT);
                Bundle mBundle = new Bundle();
                mBundle.putString("rep", "这里是服务端，我们收到信息了");
                mMessage.setData(mBundle);
                try {
                    mMessenger.send(mMessage);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    /**
     * @param intent client传来的intent
     * @return 返回给连接此service的client
     */
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "intent:" + intent.hashCode() + " data:" + intent.getStringExtra("data"));

        //在一个进程中创建指向handler的Messenger
        return new Messenger(mHandler).getBinder();
    }
}