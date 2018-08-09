package com.kortov.springworkshop.annotationbeans;

public class LuckyFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "AA and coinflips are yours!";
    }
}
