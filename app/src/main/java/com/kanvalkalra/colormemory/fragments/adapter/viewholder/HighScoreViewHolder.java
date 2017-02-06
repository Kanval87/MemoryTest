package com.kanvalkalra.colormemory.fragments.adapter.viewholder;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.kanvalkalra.colormemory.R;


public class HighScoreViewHolder extends RecyclerView.ViewHolder {
    private final AppCompatTextView name;
    private final AppCompatTextView age;

    public HighScoreViewHolder(View itemView) {
        super(itemView);
        name = (AppCompatTextView) itemView.findViewById(R.id.name);
        age = (AppCompatTextView) itemView.findViewById(R.id.age);
    }

    public AppCompatTextView getName() {
        return name;
    }

    public AppCompatTextView getAge() {
        return age;
    }
}
