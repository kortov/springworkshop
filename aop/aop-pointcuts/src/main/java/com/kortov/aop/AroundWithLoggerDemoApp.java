package com.kortov.aop;

import com.kortov.aop.dao.AccountDAO;
import com.kortov.aop.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundWithLoggerDemoApp {
    private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean(AccountDAO.class);
        TrafficFortuneService trafficFortuneService = context.getBean(TrafficFortuneService.class);
        myLogger.info("\nMain Program: AroundDemoApp");
        myLogger.info("Calling getFortune");
        String data = trafficFortuneService.getFortune();
        myLogger.info("\nMy fortune is: " + data);
        myLogger.info("Finished");
        context.close();
    }
}
