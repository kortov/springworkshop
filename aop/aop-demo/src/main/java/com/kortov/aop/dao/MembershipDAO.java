package com.kortov.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    public boolean addSillyStuff() {
        System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
        return true;
    }
}
