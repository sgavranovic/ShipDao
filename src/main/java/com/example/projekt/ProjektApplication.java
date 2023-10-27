package com.example.projekt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class ProjektApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjektApplication.class, args);
    }

}
