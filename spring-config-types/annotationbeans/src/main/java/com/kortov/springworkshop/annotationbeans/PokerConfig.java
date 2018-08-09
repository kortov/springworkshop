package com.kortov.springworkshop.annotationbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PokerConfig {
    @Bean
    public FortuneService luckyFortuneService() {
        return new LuckyFortuneService();
    }

    @Bean
    public Coach pokerCoach() {
        return new PokerCoach(luckyFortuneService());
    }
}
