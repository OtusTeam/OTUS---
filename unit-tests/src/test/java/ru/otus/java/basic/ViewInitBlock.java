package ru.otus.java.basic;

import org.junit.jupiter.api.*;

public class ViewInitBlock {
    @BeforeAll
    static void setup() {
        System.out.println("@Before - All");
    }

    @BeforeEach
    void setupThis() {
        System.out.println("@Before - Each");
    }

    @Test
    void testOne() {
        System.out.println("1 TEST");
    }

    @Test
    void testTwo() {
        System.out.println("2 TEST");
    }

    @AfterEach
    void tearThis() {
        System.out.println("@After - Each");
    }

    @AfterAll
    static void tear() {
        System.out.println("@After - All");
    }
}
