package org.testspringboot.testExample;

public class CalculatorTestOldVersion {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int param1 = 5;
        int param2 = 10;

        int expectedResultAdd = 15;
        int expectedResultMult = 50;

        int actualResultAdd = calculator.add(param1,param2);
        int actualResultMult = calculator.multiply(param1,param2);

        //=========================================

        isTestPassed("Test 1. Method 'Add' ", expectedResultAdd, actualResultAdd);

        System.out.println("==============");
        isTestPassed("Test 2. Method 'Multiplication'.", expectedResultMult, actualResultMult);

    }

    public static void isTestPassed(String message, int expected, int actual) {
        System.out.println(message);
        if (actual == expected) {
            System.out.println("Test is passed OK!");
        } else {
            System.out.println("Test is FAIL!");
            System.out.println("Expected: " + expected + ", but received: " + actual);
        }
    }
}
