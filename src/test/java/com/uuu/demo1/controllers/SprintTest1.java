package com.uuu.demo1.controllers;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

//import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class SprintTest1 {
    @Autowired
    private RootController controller;
    @BeforeAll
    static void prepareOnce() {
        System.out.println("total prepare once");
    }
    @AfterAll
    static void finalCleanup() {
        System.out.println("total cleanup");
    }

    @BeforeEach
    void prepare() {
        System.out.println("prepare data...");
    }
    @AfterEach
    void store() {
        System.out.println("store testing result...");
    }
    @Test
    void isNotNull() {
        System.out.println("test case1");
        assertThat(controller).isNotNull();
    }
    @Test
    void isNotNull2() {
        System.out.println("test case2");
        assertThat(controller).isNotNull();
    }
}
