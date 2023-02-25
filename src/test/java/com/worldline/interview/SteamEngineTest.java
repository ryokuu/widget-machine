package com.worldline.interview;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class SteamEngineTest {

    @Test
    public void startEngine(){
        SteamEngine engine = new SteamEngine(FuelType.WOOD);
        engine.fill(FuelType.WOOD, 100);
        engine.start();
        assertThat(engine.isRunning(), is(true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void initializeEngineWithIncompatibleFuel_shouldThrowException() {

        new SteamEngine(FuelType.DIESEL);
    }

    @Test(expected = IllegalStateException.class)
    public void fillSteamEngine_withIncompatibleFuelType(){
        SteamEngine engine = new SteamEngine(FuelType.COAL);
        engine.fill(FuelType.PETROL, 100);
        engine.start();
    }

    @Test(expected = IllegalStateException.class)
    public void startSteamEngineWithoutFillingFuel(){
        SteamEngine engine = new SteamEngine(FuelType.COAL);
        engine.start();
    }

    @Test(expected = IllegalStateException.class)
    public void startSteamEngineWithZeroFuel(){
        SteamEngine engine = new SteamEngine(FuelType.COAL);
        engine.fill(FuelType.COAL, 0);
        engine.start();
    }


}