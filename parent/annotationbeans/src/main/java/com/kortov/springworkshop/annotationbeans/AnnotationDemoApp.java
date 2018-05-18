package com.kortov.springworkshop.annotationbeans;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach coach = context.getBean("tennisCoach", Coach.class);
        Coach theCoach = context.getBean("swimmingCoach", Coach.class);
        System.out.println(coach.getDailyWorkout());
        System.out.println(theCoach.getDailyWorkout());
        context.close();
    }
}
