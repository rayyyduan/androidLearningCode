package com.example.viewpager;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

/**
 * Author: ruiduan
 * Date:  2021/6/4 23:37
 * Desc:
 */
public class MyPageAdapter extends PagerAdapter {
    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return false;
    }
}
