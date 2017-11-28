package com.example.springbeans;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringbeansApplication implements CommandLineRunner {

    public static void main(String[] args) {
	SpringApplication.run(SpringbeansApplication.class, args);
    }

    @Override
    public void run(String... arg0) throws Exception {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	Bushel bushel = context.getBean(Bushel.class);
	Apple apple = bushel.getApple();
	System.out.println(apple.getType());
    }
}
