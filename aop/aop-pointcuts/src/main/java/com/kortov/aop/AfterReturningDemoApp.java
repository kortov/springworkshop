package com.kortov.aop;

import com.kortov.Account;
import com.kortov.aop.dao.AccountDAO;
import com.kortov.aop.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean(AccountDAO.class);
        List<Account> accounts = accountDAO.findAccounts();
        System.out.println("\n\nMain program: AfterReturningDemoApp");
        System.out.println("-----");
        System.out.println(accounts + "\n");
        context.close();
    }
}
