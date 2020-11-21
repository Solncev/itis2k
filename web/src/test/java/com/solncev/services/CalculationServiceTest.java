package com.solncev.services;

import org.junit.Assert;
import org.junit.Test;

public class CalculationServiceTest {
    private final CalculationService service = new CalculationService();

    @Test
    public void testMultiply() {
        int result = service.multiply(4, 5);
        Assert.assertEquals(20, result);
    }

    @Test
    public void whenMultiplyWithZero_thenReturnZero() {
        int result = service.multiply(0, 5);
        Assert.assertEquals(0, result);
    }
}
