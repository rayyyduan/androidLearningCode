package com.example.viewpager;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;

/**
 * Author: ruiduan
 * Date:  2021/6/4 23:37
 * Desc:
 */
public class MyPageAdapter extends PagerAdapter {

    ArrayList<String> arrayList = new ArrayList<String>() {
        {
        add("ONE");
        add("TWO");
        add("THREE");
        }
    };

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        TextView textView = new TextView(container.getContext());
        textView.setText(arrayList.get(position));
        container.addView(textView);
        return textView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
