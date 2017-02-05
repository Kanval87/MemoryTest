package com.kanvalkalra.colormemory.fragments;


import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kanvalkalra.colormemory.R;
import com.kanvalkalra.colormemory.utils.RandomGenUtils;

import java.util.concurrent.Executors;


public class GameBoard extends Fragment {


    private String TAG = getClass().getSimpleName();
    private Handler handler;

    public GameBoard() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_game_board, container, false);
    }


    private AppCompatImageView[] cardViews;

    private Integer[] randomIntSequence;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cardViews = new AppCompatImageView[16];

        randomIntSequence = RandomGenUtils.getRandomCardSet();

        handler = new Handler();

        cardViews[0] = (AppCompatImageView) view.findViewById(R.id.r1c1);
        cardViews[1] = (AppCompatImageView) view.findViewById(R.id.r1c2);
        cardViews[2] = (AppCompatImageView) view.findViewById(R.id.r1c3);
        cardViews[3] = (AppCompatImageView) view.findViewById(R.id.r1c4);

        cardViews[4] = (AppCompatImageView) view.findViewById(R.id.r2c1);
        cardViews[5] = (AppCompatImageView) view.findViewById(R.id.r2c2);
        cardViews[6] = (AppCompatImageView) view.findViewById(R.id.r2c3);
        cardViews[7] = (AppCompatImageView) view.findViewById(R.id.r2c4);

        cardViews[8] = (AppCompatImageView) view.findViewById(R.id.r3c1);
        cardViews[9] = (AppCompatImageView) view.findViewById(R.id.r3c2);
        cardViews[10] = (AppCompatImageView) view.findViewById(R.id.r3c3);
        cardViews[11] = (AppCompatImageView) view.findViewById(R.id.r3c4);

        cardViews[12] = (AppCompatImageView) view.findViewById(R.id.r4c1);
        cardViews[13] = (AppCompatImageView) view.findViewById(R.id.r4c2);
        cardViews[14] = (AppCompatImageView) view.findViewById(R.id.r4c3);
        cardViews[15] = (AppCompatImageView) view.findViewById(R.id.r4c4);

        final AnimatorSet[] animatorFlipInSets = new AnimatorSet[16];
        final AnimatorSet[] animatorFlipOutSets = new AnimatorSet[16];

        for (int i = 0; i < 16; i++) {

            animatorFlipInSets[i] = (AnimatorSet) AnimatorInflater.loadAnimator(getActivity(), R.animator.flip_in);
            animatorFlipOutSets[i] = (AnimatorSet) AnimatorInflater.loadAnimator(getActivity(), R.animator.flip_out);

            switch (i) {
                case 0:
                case 1:
                    animatorFlipInSets[i].addListener(new AnimationListenerClass(cardViews[randomIntSequence[i]], animatorFlipOutSets[i], R.drawable.colour7));
                    animatorFlipInSets[i].addListener(new AnimationListenerClass(cardViews[randomIntSequence[i]], animatorFlipOutSets[i], R.drawable.colour7));
                    break;
                case 2:
                case 3:
                    animatorFlipInSets[i].addListener(new AnimationListenerClass(cardViews[randomIntSequence[i]], animatorFlipOutSets[i], R.drawable.colour8));
                    animatorFlipInSets[i].addListener(new AnimationListenerClass(cardViews[randomIntSequence[i]], animatorFlipOutSets[i], R.drawable.colour8));
                    break;
                case 4:
                case 5:
                    animatorFlipInSets[i].addListener(new AnimationListenerClass(cardViews[randomIntSequence[i]], animatorFlipOutSets[i], R.drawable.colour1));
                    animatorFlipInSets[i].addListener(new AnimationListenerClass(cardViews[randomIntSequence[i]], animatorFlipOutSets[i], R.drawable.colour1));
                    break;
                case 6:
                case 7:
                    animatorFlipInSets[i].addListener(new AnimationListenerClass(cardViews[randomIntSequence[i]], animatorFlipOutSets[i], R.drawable.colour2));
                    animatorFlipInSets[i].addListener(new AnimationListenerClass(cardViews[randomIntSequence[i]], animatorFlipOutSets[i], R.drawable.colour2));
                    break;
                case 8:
                case 9:
                    animatorFlipInSets[i].addListener(new AnimationListenerClass(cardViews[randomIntSequence[i]], animatorFlipOutSets[i], R.drawable.colour3));
                    animatorFlipInSets[i].addListener(new AnimationListenerClass(cardViews[randomIntSequence[i]], animatorFlipOutSets[i], R.drawable.colour3));
                    break;
                case 10:
                case 11:
                    animatorFlipInSets[i].addListener(new AnimationListenerClass(cardViews[randomIntSequence[i]], animatorFlipOutSets[i], R.drawable.colour4));
                    animatorFlipInSets[i].addListener(new AnimationListenerClass(cardViews[randomIntSequence[i]], animatorFlipOutSets[i], R.drawable.colour4));
                    break;
                case 12:
                case 13:
                    animatorFlipInSets[i].addListener(new AnimationListenerClass(cardViews[randomIntSequence[i]], animatorFlipOutSets[i], R.drawable.colour5));
                    animatorFlipInSets[i].addListener(new AnimationListenerClass(cardViews[randomIntSequence[i]], animatorFlipOutSets[i], R.drawable.colour5));
                    break;
                case 14:
                case 15:
                    animatorFlipInSets[i].addListener(new AnimationListenerClass(cardViews[randomIntSequence[i]], animatorFlipOutSets[i], R.drawable.colour6));
                    animatorFlipInSets[i].addListener(new AnimationListenerClass(cardViews[randomIntSequence[i]], animatorFlipOutSets[i], R.drawable.colour6));
                    break;
            }

            final int finalI = i;
            cardViews[randomIntSequence[finalI]].setTag(finalI);
            cardViews[randomIntSequence[finalI]].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (currentSelected < 2) {

                        Integer position = (Integer) v.getTag();

                        switch (currentSelected) {
                            case 0:
                                selectedPayLoads[0] = position;
                                break;
                            case 1:
                                selectedPayLoads[1] = position;
                                break;
                            default:
                                break;
                        }

                        ++currentSelected;

                        animatorFlipInSets[position].setTarget(v);
                        animatorFlipInSets[position].start();

                        if (currentSelected == 2) {
                            ((AnimationListenerClass) animatorFlipInSets[position].getListeners().get(0)).resetImages();
                        }
                    }
                }
            });
        }
    }

    private Integer[] selectedPayLoads = new Integer[2];


    private int currentSelected = 0;

    class AnimationListenerClass implements Animator.AnimatorListener {

        private AppCompatImageView appCompatImageView;
        private AnimatorSet animatorFlipInSet;
        private int colorBackground;
        private boolean resetImages;

        public AnimationListenerClass(AppCompatImageView appCompatImageView, AnimatorSet animatorFlipInSet, int colorBackground) {
            this.appCompatImageView = appCompatImageView;
            this.animatorFlipInSet = animatorFlipInSet;
            this.colorBackground = colorBackground;
        }

        @Override
        public void onAnimationStart(Animator animation) {

        }

        @Override
        public void onAnimationEnd(Animator animation) {
            appCompatImageView.setImageResource(colorBackground);
            animatorFlipInSet.setTarget(appCompatImageView);
            animatorFlipInSet.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    Executors.newSingleThreadExecutor().submit(new Runnable() {
                        @Override
                        public void run() {

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if (resetImages) {
                                        for (Integer payLoad : selectedPayLoads) {
                                            cardViews[randomIntSequence[payLoad]].setImageResource(R.drawable.card_bg);
                                        }
                                        currentSelected = 0;
                                    }
                                    resetImages = false;
                                }
                            });

                        }
                    });
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

        public void resetImages() {
            this.resetImages = true;
        }
    }


}
