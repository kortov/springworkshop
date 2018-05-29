package com.kortov.springworkshop.annotationbeans;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PokerJavaConfigDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PokerConfig.class);
        PokerCoach coach = context.getBean("pokerCoach", PokerCoach.class);
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
        context.close();
    }
}
