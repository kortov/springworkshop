package com.kortov.springworkshop.annotationbeans;

import org.springframework.stereotype.Component;

@Component
public class SwimmingCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Swim 1 kilometer";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
