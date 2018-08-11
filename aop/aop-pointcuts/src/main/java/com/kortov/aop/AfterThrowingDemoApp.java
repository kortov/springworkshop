package com.kortov.aop;

import com.kortov.Account;
import com.kortov.aop.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean(AccountDAO.class);
        List<Account> accounts = null;
        try {
            boolean tripWire = true;
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
