package com.example.projekt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.bson.assertions.Assertions.assertNotNull;

@SpringBootTest
class ProjektApplicationTests {

    @Autowired
    private ApplicationContext context;

    @Test
    void contextLoads() {
        assertNotNull(context);
        for (String beanName: context.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
    }

}
