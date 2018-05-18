package com.kortov.springworkshop.xmlbeans;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
        BaseballCoach baseballCoachNY = context.getBean("myBaseballCoach", BaseballCoach.class);
        BaseballCoach baseballCoachLA = context.getBean("myBaseballCoach", BaseballCoach.class);
        boolean baseballResult = (baseballCoachNY == baseballCoachLA);
        System.out.println("\nBaseballCoaches (prototype) are pointing to the same object: " + baseballResult);
        System.out.println("\nMemory location for baseballCoachNY: " + baseballCoachNY);
        System.out.println("\nMemory location for baseballCoachLA: " + baseballCoachLA);
        System.out.println("----------------------");

        FootballCoach footballCoachBarcelona = context.getBean("myFootballCoach", FootballCoach.class);
        FootballCoach footballCoachMadrid = context.getBean("myFootballCoach", FootballCoach.class);
        boolean footballResult = (footballCoachBarcelona == footballCoachMadrid);
        System.out.println("\nFootballCoaches (singleton) are pointing to the same object: " + footballResult);
        System.out.println("\nMemory location for footballCoachBarcelona: " + footballCoachBarcelona);
        System.out.println("\nMemory location for footballCoachMadrid: " + footballCoachMadrid);

        context.close();
    }
}
