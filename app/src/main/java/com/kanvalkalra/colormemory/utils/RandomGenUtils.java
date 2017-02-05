package com.kanvalkalra.colormemory.utils;


import com.kanvalkalra.colormemory.game.helper.CardSet;
import com.kanvalkalra.colormemory.game.helper.custom.exception.GivenCardNumberIsSame;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class RandomGenUtils {

    public static void getRandomCardSet(CardSet[] cardSets) {
        Random random = new Random();

        Set<Number> orderNumbers = new LinkedHashSet<>(16);
        while (true) {
            int randomNum = random.nextInt(16);
            orderNumbers.add(randomNum);
            if (orderNumbers.size() >= 16) {
                break;
            }
        }

        Number[] numbers = new Number[orderNumbers.size()];
        orderNumbers.toArray(numbers);

        for (int i = 0; i < orderNumbers.size(); i = i + 2) {
            cardSets[i / 2] = new CardSet();
            try {
                cardSets[i / 2].setFirstCard(numbers[i].intValue());
            } catch (GivenCardNumberIsSame givenCardNumberIsSame) {
                givenCardNumberIsSame.printStackTrace();
            }
            try {
                cardSets[i / 2].setSecondCard(numbers[i + 1].intValue());
            } catch (GivenCardNumberIsSame givenCardNumberIsSame) {
                givenCardNumberIsSame.printStackTrace();
            }
            System.out.println(cardSets[i / 2]);
        }
    }


}
