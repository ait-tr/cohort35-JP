package org.testspringboot.mockitoTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TaxCalculator2024Test {

    @Test
    void calculateTaxForNot2022() {

        CurrentYearProvider currentYearProvider = new CurrentYearProviderImpl();
        TaxCalculator2024 taxCalculator2024 = new TaxCalculator2024(currentYearProvider);

        double taxAmount = taxCalculator2024.calculateTax(10000);
        assertEquals(2500, taxAmount);
    }

    @Test
    void calculateTaxFor2022() {

        CurrentYearProvider currentYearProvider = mock(CurrentYearProvider.class);
        TaxCalculator2024 taxCalculator2024 = new TaxCalculator2024(currentYearProvider);
        when(currentYearProvider.getYear()).thenReturn(2022);

        double taxAmount = taxCalculator2024.calculateTax(10000);
        assertEquals(2200, taxAmount);
    }

}