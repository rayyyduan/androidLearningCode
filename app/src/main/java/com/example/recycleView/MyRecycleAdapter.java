package com.example.recycleView;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.jetpack.lifecycle.LifeCycleActivity;
import com.example.jetpack.lifedata.LiveDataActivity;
import com.example.jetpack.viewmodel.ViewModelActivity;
import com.example.viewpager.ViewPagerActivity;
import java.util.ArrayList;

/**
 * Author: ruiduan
 * Date:  2021/6/5 0:46
 * Desc:
 */
public class MyRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final String TAG = this.getClass().getSimpleName();

    private static final ArrayList<Class<? extends Activity>> arrayList = new ArrayList<>();

    static {
        arrayList.add(LifeCycleActivity.class);
        arrayList.add(ViewPagerActivity.class);
        arrayList.add(LiveDataActivity.class);
        arrayList.add(ViewModelActivity.class);
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Button button = new Button(parent.getContext());
        return new ItemViewHolder(button);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ((ItemViewHolder) holder).setClazz(arrayList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    static class ItemViewHolder extends RecyclerView.ViewHolder {

        Button button;
        Class<? extends Activity> clazz;

        public ItemViewHolder(View itemView) {
            super(itemView);
            button = (Button) itemView;
            itemView.setTag(this);
        }

        public void setClazz(Class<? extends Activity> clazz) {
            this.clazz = clazz;
            this.button.setText(clazz.getSimpleName());
            this.button.setOnClickListener((v -> {
                Intent intent = new Intent(button.getContext(), clazz);
                button.getContext().startActivity(intent);
            }));
        }

    }
}
