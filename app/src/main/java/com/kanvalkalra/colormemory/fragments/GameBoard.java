package com.kanvalkalra.colormemory.fragments;


import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kanvalkalra.colormemory.R;


public class GameBoard extends Fragment {


    private String TAG = getClass().getSimpleName();

    public GameBoard() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_game_board, container, false);
    }

    AppCompatImageView[][] cardViews;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cardViews = new AppCompatImageView[4][4];

        cardViews[0][0] = (AppCompatImageView) view.findViewById(R.id.r1c1);
        cardViews[0][1] = (AppCompatImageView) view.findViewById(R.id.r1c2);
        cardViews[0][2] = (AppCompatImageView) view.findViewById(R.id.r1c3);
        cardViews[0][3] = (AppCompatImageView) view.findViewById(R.id.r1c4);

        cardViews[1][0] = (AppCompatImageView) view.findViewById(R.id.r2c1);
        cardViews[1][1] = (AppCompatImageView) view.findViewById(R.id.r2c2);
        cardViews[1][2] = (AppCompatImageView) view.findViewById(R.id.r2c3);
        cardViews[1][3] = (AppCompatImageView) view.findViewById(R.id.r2c4);

        cardViews[2][0] = (AppCompatImageView) view.findViewById(R.id.r3c1);
        cardViews[2][1] = (AppCompatImageView) view.findViewById(R.id.r3c2);
        cardViews[2][2] = (AppCompatImageView) view.findViewById(R.id.r3c3);
        cardViews[2][3] = (AppCompatImageView) view.findViewById(R.id.r3c4);

        cardViews[3][0] = (AppCompatImageView) view.findViewById(R.id.r4c1);
        cardViews[3][1] = (AppCompatImageView) view.findViewById(R.id.r4c2);
        cardViews[3][2] = (AppCompatImageView) view.findViewById(R.id.r4c3);
        cardViews[3][3] = (AppCompatImageView) view.findViewById(R.id.r4c4);

        final AnimatorSet[][] animatorFlipInSets = new AnimatorSet[4][4];
        final AnimatorSet[][] animatorFlipOutSets = new AnimatorSet[4][4];

        for (int i = 0; i < (cardViews.length); i++) {
            for (int j = 0; j < cardViews[0].length; j++) {
                final int finalI = i;
                final int finalJ = j;
                animatorFlipInSets[finalI][finalJ] = (AnimatorSet) AnimatorInflater.loadAnimator(getActivity(), R.animator.flip_in);
                animatorFlipOutSets[finalI][finalJ] = (AnimatorSet) AnimatorInflater.loadAnimator(getActivity(), R.animator.flip_out);
                animatorFlipInSets[finalI][finalJ].addListener(new AnimationListenerClass(cardViews[finalI][finalJ], animatorFlipOutSets[finalI][finalJ], animatorFlipOutSets[finalI][finalJ]));
                cardViews[finalI][finalJ].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        animatorFlipInSets[finalI][finalJ].setTarget(v);
                        animatorFlipInSets[finalI][finalJ].start();
                    }
                });
            }
        }


    }

    class AnimationListenerClass implements Animator.AnimatorListener {

        private AppCompatImageView appCompatImageView;
        private AnimatorSet animatorFlipInSet;
        private AnimatorSet animatorFlipOutSet;

        public AnimationListenerClass(AppCompatImageView appCompatImageView, AnimatorSet animatorFlipInSet, AnimatorSet animatorFlipOutSet) {
            this.appCompatImageView = appCompatImageView;
            this.animatorFlipInSet = animatorFlipInSet;
            this.animatorFlipOutSet = animatorFlipOutSet;
        }

        @Override
        public void onAnimationStart(Animator animation) {

        }

        @Override
        public void onAnimationEnd(Animator animation) {
            appCompatImageView.setImageResource(R.drawable.colour1);
            animatorFlipInSet.setTarget(appCompatImageView);
            animatorFlipInSet.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    appCompatImageView.setImageResource(R.drawable.card_bg);
                    animatorFlipOutSet.setTarget(appCompatImageView);
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
            animatorFlipInSet.start();
        }

        @Override
        public void onAnimationCancel(Animator animation) {

        }

        @Override
        public void onAnimationRepeat(Animator animation) {

        }
    }


}
