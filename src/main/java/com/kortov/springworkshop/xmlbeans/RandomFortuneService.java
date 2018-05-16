package com.kortov.springworkshop.xmlbeans;

import java.util.Random;

public class RandomFortuneService implements FortuneService {

    private String[] fortunes;

    public RandomFortuneService() {
        fortunes = new String[]{"Good luck!", "Way to go!", "Sheeeeit!"};
    }

    @Override
    public String getFortune() {
        Random random = new Random();
        int index = random.nextInt(fortunes.length);
        return fortunes[index];
    }
}
