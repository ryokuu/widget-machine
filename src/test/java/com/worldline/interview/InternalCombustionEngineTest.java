package com.worldline.interview;

import org.junit.Test;

public class InternalCombustionEngineTest {

    @Test(expected = IllegalArgumentException.class)
    public void initializeEngineWithIncompatibleFuel_shouldThrowException() {

        new InternalCombustionEngine(FuelType.COAL);
    }
}