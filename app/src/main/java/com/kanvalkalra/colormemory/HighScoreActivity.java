package com.kanvalkalra.colormemory;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kanvalkalra.colormemory.fragments.HighScore;

public class HighScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);
        try {
            getActionBar().hide();
        } catch (Exception e) {
            e.printStackTrace();
        }
        setDefaultFragment();
    }

    private void setDefaultFragment() {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new HighScore());
        fragmentTransaction.commit();
    }
}
