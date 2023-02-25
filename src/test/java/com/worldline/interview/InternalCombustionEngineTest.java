package com.worldline.interview;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class InternalCombustionEngineTest {

    @Test
    public void startEngine(){
        InternalCombustionEngine engine = new InternalCombustionEngine(FuelType.DIESEL);
        engine.fill(FuelType.DIESEL, 75);
        engine.start();
        assertThat(engine.isRunning(), is(true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void initializeEngineWithIncompatibleFuel_shouldThrowException() {

        new InternalCombustionEngine(FuelType.COAL);
    }

    @Test(expected = IllegalStateException.class)
    public void fillEngine_withIncompatibleFuelType(){
        InternalCombustionEngine engine = new InternalCombustionEngine(FuelType.PETROL);
        engine.fill(FuelType.WOOD, 100);
        engine.start();
    }

    @Test(expected = IllegalStateException.class)
    public void startEngineWithoutFillingFuel(){
        InternalCombustionEngine engine = new InternalCombustionEngine(FuelType.PETROL);
        engine.start();
    }

    @Test(expected = IllegalStateException.class)
    public void startEngineWithZeroFuel(){
        InternalCombustionEngine engine = new InternalCombustionEngine(FuelType.PETROL);
        engine.fill(FuelType.PETROL, 0);
        engine.start();
    }
}