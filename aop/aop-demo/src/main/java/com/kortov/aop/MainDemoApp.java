package com.kortov.aop;

import com.kortov.aop.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean(AccountDAO.class);
        accountDAO.addAccount();
        System.out.println("\nlet's call it again!\n");
        accountDAO.addAccount();
        context.close();
    }
}
