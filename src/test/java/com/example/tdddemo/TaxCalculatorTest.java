package com.example.tdddemo;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class TaxCalculatorTest {

    @Test
    public void when_income_less_than_500kUSD_then_deducts_10percent_tax() {
        TaxCalculator calculator = new TaxCalculator();
        double payableTax = calculator.calculate(400000.00);
        assertTrue(40000.00 == payableTax);

        payableTax = calculator.calculate(0.00);
        assertTrue(0.00 == payableTax);

        payableTax = calculator.calculate(500000.00);
        assertTrue(50000.00 == payableTax);
    }

    @Test
    public void when_income_between_500kUSD_1mUSD_then_deducts_50kUSD_plus_20percent_above_500kUSD_tax() {
        TaxCalculator calculator = new TaxCalculator();
        double payableTax = calculator.calculate(600000.00);
        assertTrue(70000.00 == payableTax);

        payableTax = calculator.calculate(1000000.00);
        assertTrue(150000.00 == payableTax);
    }

    @Test
    public void when_income_greater_than_1mUSD_then_deducts_150kUSD_plus_30percent_above_1mUSD_tax() {
        TaxCalculator calculator = new TaxCalculator();
        double payableTax = calculator.calculate(1600000.00);
        assertTrue(330000.00 == payableTax);
    }
}
