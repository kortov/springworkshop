package com.kortov.aop;

import com.kortov.aop.dao.AccountDAO;
import com.kortov.aop.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean(AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean(MembershipDAO.class);
        accountDAO.addAccount();
        membershipDAO.addSillyStuff();
        context.close();
    }
}
