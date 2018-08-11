package com.kortov.aop;

import com.kortov.aop.dao.AccountDAO;
import com.kortov.aop.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundHandleExceptionDemoApp {
    private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean(AccountDAO.class);
        TrafficFortuneService trafficFortuneService = context.getBean(TrafficFortuneService.class);
        myLogger.info("\nMain Program: AroundDemoApp");
        myLogger.info("Calling getFortune");
        boolean tripWire = true;
        String data = trafficFortuneService.getFortune(tripWire);
        myLogger.info("\nMy fortune is: " + data);
        myLogger.info("Finished");
        context.close();
    }
}
