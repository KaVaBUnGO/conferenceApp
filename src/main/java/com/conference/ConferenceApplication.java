package com.conference;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan
@EnableAutoConfiguration
@EnableJpaRepositories
public class ConferenceApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ConferenceApplication.class, args);
    }
}
