package com.kortov.springworkshop.xmlbeans;

public class FootballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Kick the ball 100 times";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
