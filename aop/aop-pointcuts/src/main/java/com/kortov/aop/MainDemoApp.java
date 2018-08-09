package com.kortov.aop;

import com.kortov.Account;
import com.kortov.aop.dao.AccountDAO;
import com.kortov.aop.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean(AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean(MembershipDAO.class);
        accountDAO.addAccount(new Account(), true);
        membershipDAO.addSillyStuff();
        accountDAO.doWork();
        membershipDAO.goToSleep();
        accountDAO.setName("foobar");
        accountDAO.setServiceCode("silver");

        String name = accountDAO.getName();
        String code = accountDAO.getServiceCode();
        context.close();
    }
}
