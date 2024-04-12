package org.testspringboot.mockitoTest;

public class TaxCalculator2024 {

    private CurrentYearProvider currentYearProvider;

    public TaxCalculator2024(CurrentYearProvider currentYearProvider) {
        this.currentYearProvider = currentYearProvider;
    }

    public double calculateTax(double income){
        double taxAmount = 0;

        if (currentYearProvider.getYear() == 2022) {
            taxAmount = income * 0.22;
        } else {
            taxAmount = income * 0.25;
        }

        return taxAmount;
    }
}
