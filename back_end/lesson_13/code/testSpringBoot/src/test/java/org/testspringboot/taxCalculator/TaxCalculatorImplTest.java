package org.testspringboot.taxCalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaxCalculatorImplTest {

    @Test
    void calculateTaxLess20000() {
        TaxCalculatorImpl taxCalculator = new TaxCalculatorImpl();

        double income = 100;
        double expectedTax = 25;
        double actualTax = taxCalculator.calculateTax(income);

        assertEquals(expectedTax, actualTax);
    }

    @Test
    void calculateTaxMore20000() {
        TaxCalculatorImpl taxCalculator = new TaxCalculatorImpl();

        double income = 30_000;
        double expectedTax = 9000;
        double actualTax = taxCalculator.calculateTax(income);

        assertEquals(expectedTax, actualTax);
    }


}