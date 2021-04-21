package me.study.realworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
public class RealworldJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(RealworldJavaApplication.class, args);
    }

}
