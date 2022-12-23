package com.lefnds.practicingtests.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void ReturnZeroWhenNoValuesWereGiven() {
        Calculator calculator = new Calculator();
        double sum = calculator.sum();
        Assertions.assertEquals(0, sum);
    }

    @Test
    public void ReturnTheSumOfGivenValues() {
        Calculator calculator = new Calculator();
        double sum = calculator.sum(2, 2);
        Assertions.assertEquals(4, sum);
    }

    @Test
    public void ThrowIllegalArgumentExceptionWhenTheValueGivenIsNegative() {
        Calculator calculator = new Calculator();
        IllegalArgumentException ex = Assertions.assertThrows( IllegalArgumentException.class, () -> calculator.sqrt( -1 ) );
        Assertions.assertEquals("Invalid number", ex.getMessage());
    }

    @Test
    public void ReturnSquareRootOfTheValueGiven() {
        Calculator calculator = new Calculator();
        double sqrt = calculator.sqrt(4);
        Assertions.assertEquals(2, sqrt);
    }

    @Test
    public void ReturnTrueWhenTheNumberGivenIsOdd() {
        Calculator calculator = new Calculator();
        boolean isOdd = calculator.isOdd(3);
        Assertions.assertTrue(isOdd);
    }

    @Test
    public void ReturnFalseWhenTheNumberGivenIsEven() {
        Calculator calculator = new Calculator();
        boolean isOdd = calculator.isOdd(4);
        Assertions.assertFalse(isOdd);
    }
}
