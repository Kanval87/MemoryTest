package com.kanvalkalra.colormemory.utils;


import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class RandomGenUtils {

    public static Integer[] getRandomCardSet() {
        Random random = new Random();

        Set<Integer> orderNumbers = new LinkedHashSet<>(16);
        while (true) {
            int randomNum = random.nextInt(16);
            orderNumbers.add(randomNum);
            if (orderNumbers.size() >= 16) {
                break;
            }
        }

        Integer[] numbers = new Integer[orderNumbers.size()];
        orderNumbers.toArray(numbers);

        return numbers;

//        for (int i = 0; i < orderNumbers.size(); i = i + 2) {
//            cardSets[i / 2] = new CardSet();
//            try {
//                cardSets[i / 2].setFirstCard(numbers[i].intValue());
//            } catch (GivenCardNumberIsSame givenCardNumberIsSame) {
//                givenCardNumberIsSame.printStackTrace();
//            }
//            try {
//                cardSets[i / 2].setSecondCard(numbers[i + 1].intValue());
//            } catch (GivenCardNumberIsSame givenCardNumberIsSame) {
//                givenCardNumberIsSame.printStackTrace();
//            }
//            System.out.println(cardSets[i / 2]);
//        }
    }


}
