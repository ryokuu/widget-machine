package com.worldline.interview;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class WidgetMachineTest {

    @Test
    public void produceWidgets_withInternalCombustionAndDiesel() {
        InternalCombustionEngine engine = new InternalCombustionEngine(FuelType.DIESEL);
        engine.fill(FuelType.DIESEL, 100);
        WidgetMachine widgetMachine = new WidgetMachine(engine);

        //using the hamcrest
        assertThat(widgetMachine.produceWidgets(9).doubleValue(), equalTo(24.0));
    }

    @Test
    public void ProduceWidgets_withInternalCombustionAndPetrol() {
        InternalCombustionEngine engine = new InternalCombustionEngine(FuelType.PETROL);
        engine.fill(FuelType.PETROL, 100);
        WidgetMachine widgetMachine = new WidgetMachine(engine);

        assertEquals(18.0, widgetMachine.produceWidgets(9).doubleValue(), 0);
    }

    @Test
    public void ProduceWidgets_withSteamEngineAndWood() {
        SteamEngine engine = new SteamEngine(FuelType.WOOD);
        engine.fill(FuelType.WOOD, 100);
        WidgetMachine widgetMachine = new WidgetMachine(engine);

        assertEquals(4.35, widgetMachine.produceWidgets(1).doubleValue(), 0);
    }

    @Test
    public void ProduceWidgets_withSteamEngineAndCoal(){
        SteamEngine engine = new SteamEngine(FuelType.COAL);
        engine.fill(FuelType.COAL, 100);
        WidgetMachine widgetMachine = new WidgetMachine(engine);

        assertEquals(11.3, widgetMachine.produceWidgets(3).doubleValue(), 0);
    }

}