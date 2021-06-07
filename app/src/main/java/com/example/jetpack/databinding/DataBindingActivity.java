package com.example.jetpack.databinding;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.activity.R;

/**
 * Author: ruiduan
 * Date:  2021/6/5 23:25
 * Desc:
 */
public class DataBindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.empty_layout);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
