package com.example.viewpager;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.example.activity.R;

/**
 * Author: ruiduan
 * Date:  2021/6/4 23:20
 * Desc:
 */
public class ViewPagerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager_activity);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ViewPager viewpager = findViewById(R.id.viewpager);
        viewpager.setAdapter(new MyPageAdapter());
    }
}
