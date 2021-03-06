package com.kanvalkalra.colormemory;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kanvalkalra.colormemory.fragments.GameBoard;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            getActionBar().hide();
        } catch (Exception e) {
            e.printStackTrace();
        }
        setDefaultFragment();
    }

    private void setDefaultFragment() {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new GameBoard());
        fragmentTransaction.commit();
    }

}
