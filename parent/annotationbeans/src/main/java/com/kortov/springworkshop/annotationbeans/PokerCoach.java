package com.kortov.springworkshop.annotationbeans;

public class PokerCoach implements Coach {
    FortuneService fortuneService;

    public PokerCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "play 5k hands";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
