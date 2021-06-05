package com.example.jetpack.viewmodel;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.example.activity.R;

/**
 * Author: ruiduan
 * Date:  2021/6/5 20:41
 * Desc:
 */
public class ViewModelActivity extends AppCompatActivity {
    MyViewModel myViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_model_activity);

        TextView textView = findViewById(R.id.view_model_text);
        Button btn = findViewById(R.id.view_model_btn);

        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        myViewModel.getLiveData().observe(this, textView::setText);

        btn.setOnClickListener(v -> myViewModel.MockNetReq());
    }

    public static class MyViewModel extends ViewModel {
        private final MutableLiveData<String> liveData = new MutableLiveData<>();

        public MutableLiveData<String> getLiveData() {
            return liveData;
        }

        public void MockNetReq() {
            liveData.setValue("onClick");
        }
    }
}

