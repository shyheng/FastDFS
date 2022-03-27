package com.example;

import com.example.fast.service.IFastService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootFastDfsApplicationTests {

    @Autowired
    IFastService iFastService;

    @Test
    void contextLoads() {
        System.out.println(iFastService.list().get(0).getName());
    }

}
