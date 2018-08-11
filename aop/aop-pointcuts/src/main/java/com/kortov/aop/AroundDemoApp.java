package com.kortov.aop;

import com.kortov.Account;
import com.kortov.aop.dao.AccountDAO;
import com.kortov.aop.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AroundDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean(AccountDAO.class);
        TrafficFortuneService trafficFortuneService = context.getBean(TrafficFortuneService.class);
        System.out.println("\nMain Program: AroundDemoApp");
        System.out.println("Calling getFortune");
        String data = trafficFortuneService.getFortune();
        System.out.println("\nMy fortune is: " + data);
        System.out.println("Finished");
        context.close();
    }
}
