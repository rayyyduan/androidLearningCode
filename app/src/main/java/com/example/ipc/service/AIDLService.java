package com.example.ipc.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.example.activity.IAIDLManager;

/**
 * Author: ruiduan
 * Date:  2022/2/17 11:15
 * Desc:  aidl
 */
public class AIDLService extends Service {

    String mData = "";
    private final IAIDLManager.Stub mStub= new IAIDLManager.Stub() {

        @Override
        public void setData(String data) throws RemoteException {
            mData = data;
        }

        @Override
        public String getData() throws RemoteException {
            return mData;
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        return mStub.asBinder();
    }
}
