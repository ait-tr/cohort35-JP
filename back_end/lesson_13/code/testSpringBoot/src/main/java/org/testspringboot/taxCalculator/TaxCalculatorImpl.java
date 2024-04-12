package org.testspringboot.taxCalculator;

public class TaxCalculatorImpl implements TaxCalculator{
    @Override
    public double calculateTax(double income) {
        /*
        рассчитать налоги если ставка налога до 20 000 евро 25%,
        а свыше 20 000 - 40% (прогрессивная шкала)
         */

        double taxAmount = 0;

        if (income <= 20_000) {
            taxAmount = income * 0.25;
        } else {
            taxAmount = 20_000 * 0.25 + (income - 20_000) * 0.4;
        }

        return taxAmount;
    }
}
