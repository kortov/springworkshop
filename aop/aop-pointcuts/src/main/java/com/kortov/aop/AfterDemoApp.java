package com.kortov.aop;

import com.kortov.Account;
import com.kortov.aop.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean(AccountDAO.class);
        List<Account> accounts = null;
        try {
            boolean tripWire = false;
            accounts = accountDAO.findAccounts(tripWire);
        } catch (Exception e) {
            System.out.println("\n\nMain program: .. caught exception" + e);
        }
        System.out.println("\n\nMain program: AfterThrowingDemoApp");
        System.out.println("-----");
        System.out.println(accounts + "\n");
        context.close();
    }
}
