package com.example.tdddemo;

public class TaxCalculator {
    public double calculate(double income) {
        double tax = 0.00;

        if(isIncomeIn30Percent(income)) {
            tax = deduct30PercentAbove1m(income) + calculate(1000000.00);
        } else if(isIncomeIn20Percent(income)){
            tax = deduct20PercentAbove500k(income) + calculate(500000.00);
        } else if(isIncomeIn10Percent(income)) {
            tax = income * 0.10;
        }
        return tax;
    }

    protected double deduct20PercentAbove500k(double income) {
        return (income - 500000.00) * 0.20;
    }

    private boolean isIncomeIn10Percent(double income) {
        return (income >= 0 && income <= 500000.00);
    }

    private boolean isIncomeIn20Percent(double income) {
        return (income > 500000.00 && income <= 1000000.00);
    }

    private boolean isIncomeIn30Percent(double income) {
        return income > 1000000.00;
    }

    protected double deduct30PercentAbove1m(double income) {
        return (income - 1000000.00) * 0.30;
    }
}
