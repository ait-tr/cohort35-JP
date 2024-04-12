package org.testspringboot.testExamples;

import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class JunitAnnotationExample {

    private List<String> list = new ArrayList<>();

    @BeforeAll
    public static void method1() {
        System.out.println("Using @BeforeAll, executing before all test cases");
    }
    @BeforeEach
    public void method2() {
        System.out.println("Using @BeforeEach, executing before each test cases");
    }

    @Test
    public void method3() {
        list.add("test");
        assertEquals(1, list.size());
        assertFalse(list.isEmpty());
    }

    @Test
    public void method33() {
        list.add("test2");
        assertEquals(1, list.size());
        assertFalse(list.isEmpty());
    }

    @AfterEach
    public void method4() {
        System.out.println("Using @AfterEach, executing after each test cases");

    }

    @AfterAll
    public static void method5() {
        System.out.println("Using @AfterAll, executing after all test cases");
    }
}
