package com.kanvalkalra.colormemory.game.helper;

import com.kanvalkalra.colormemory.game.helper.custom.exception.GivenCardNumberIsSame;


public class CardSet {

    private int firstCard = -1;
    private int secondCard = -1;

    public int getFirstCard() {
        return firstCard;
    }

    public void setFirstCard(int firstCard) throws GivenCardNumberIsSame {
        if (firstCard != this.secondCard) {
            this.firstCard = firstCard;
        } else {
            throw new GivenCardNumberIsSame();
        }
    }

    public int getSecondCard() {
        return secondCard;
    }

    public void setSecondCard(int secondCard) throws GivenCardNumberIsSame {
        if (secondCard != this.firstCard) {
            this.secondCard = secondCard;
        } else {
            throw new GivenCardNumberIsSame();
        }
    }

    @Override
    public String toString() {
        return "CardSet{" +
                "firstCard=" + firstCard +
                ", secondCard=" + secondCard +
                '}';
    }
}
