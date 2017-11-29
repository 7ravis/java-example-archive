package com.example.springbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Apple apple1() {
	return new HoneyCrisp();
    }

    /*
     * the method below could have been used instead of using @Component
     * and @Autowired in the Bushel class. this would make the @ComponentScan
     * annotation on this class unnecessary.
     */
    // @Bean
    // public Bushel bushel() {
    // return new Bushel(apple());
    // }
}
