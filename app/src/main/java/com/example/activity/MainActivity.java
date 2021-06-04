package com.example.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.jetpack.LifeCycleActivity;
import com.example.viewpager.MyViewPagerActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lifecycle_btn:
                startActivity(new Intent(this, LifeCycleActivity.class));
            case R.id.view_pager_btn:
                startActivity(new Intent(this, MyViewPagerActivity.class));
        }

    }

}