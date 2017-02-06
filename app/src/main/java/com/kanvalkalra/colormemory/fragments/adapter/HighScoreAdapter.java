package com.kanvalkalra.colormemory.fragments.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.kanvalkalra.colormemory.R;
import com.kanvalkalra.colormemory.db.HighScoreUser;
import com.kanvalkalra.colormemory.fragments.adapter.viewholder.HighScoreViewHolder;

import java.util.ArrayList;

/**
 * Created by kanvalkalra on 6/2/17.
 */
public class HighScoreAdapter extends RecyclerView.Adapter<HighScoreViewHolder> {
    private ArrayList<HighScoreUser> highScoreUsers;

    public HighScoreAdapter(ArrayList<HighScoreUser> highScoreUsers) {
        this.highScoreUsers = highScoreUsers;
    }

    @Override
    public HighScoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HighScoreViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_high_score, parent, false));
    }

    @Override
    public void onBindViewHolder(HighScoreViewHolder holder, int position) {
        holder.getName().setText(highScoreUsers.get(position).getName());
        holder.getAge().setText(String.format("%d", highScoreUsers.get(position).getScore()));
    }

    @Override
    public int getItemCount() {
        return highScoreUsers != null ? highScoreUsers.size() : 0;
    }
}
