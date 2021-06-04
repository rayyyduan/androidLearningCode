package com.example.activity;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.MyLog;
import com.example.recycleView.MyRecycleAdapter;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycle_view);
        recyclerView.setAdapter(new MyRecycleAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyLog.e(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}