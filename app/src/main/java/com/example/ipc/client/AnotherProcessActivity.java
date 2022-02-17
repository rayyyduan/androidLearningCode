package com.example.ipc.client;

import static com.example.C.DATA;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.activity.R;

/**
 * Author: ruiduan
 * Date:  2022/2/16 10:27
 * Desc: 跨进程的activity，可以通过intent传数据
 */
public class AnotherProcessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_layout);
        ((TextView) findViewById(R.id.single_text)).setText(getIntent().getStringExtra(DATA));
    }
}
