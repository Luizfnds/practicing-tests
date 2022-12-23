package com.lefnds.practicingtests.calculator;

public class Calculator {

    public double sum(double... numbers) {
        double sum = 0;

        for(double number : numbers) {
            sum += number;
        }

        return sum;
    }

    public double sqrt(double number) {
        if(number < 0) {
            throw new IllegalArgumentException("Invalid number");
        }
        return Math.sqrt(number);
    }

    public boolean isOdd(int number) {
        return number % 2 != 0;
    }
}
