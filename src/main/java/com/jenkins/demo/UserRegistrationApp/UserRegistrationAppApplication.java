package com.jenkins.demo.UserRegistrationApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.jenkins.demo.UserRegistrationApp")
public class UserRegistrationAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserRegistrationAppApplication.class, args);
	}

}
