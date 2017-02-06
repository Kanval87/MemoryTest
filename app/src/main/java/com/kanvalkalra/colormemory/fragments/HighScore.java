package com.kanvalkalra.colormemory.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kanvalkalra.colormemory.R;
import com.kanvalkalra.colormemory.db.HighScoreUser;
import com.kanvalkalra.colormemory.db.HighScoreUserDao;
import com.kanvalkalra.colormemory.fragments.adapter.HighScoreAdapter;
import com.kanvalkalra.colormemory.global.data.App;

import java.util.ArrayList;


public class HighScore extends Fragment {


    public HighScore() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_high_score, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ArrayList<HighScoreUser> highScoreUsers = null;
        try {
            highScoreUsers = (ArrayList<HighScoreUser>) ((App) getActivity().getApplication()).getDaoSession().getHighScoreUserDao().queryBuilder().orderDesc(HighScoreUserDao.Properties.Score).build().list();
        } catch (Exception e) {
            e.printStackTrace();
        }


        recyclerView.setAdapter(new HighScoreAdapter(highScoreUsers));
    }
}
