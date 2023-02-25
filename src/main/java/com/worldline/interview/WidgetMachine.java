package com.worldline.interview;

import java.math.BigDecimal;

public class WidgetMachine {

    private final EngineType selectedEngine;
    private InternalCombustionEngine internalCombustionEngine;
    private SteamEngine steamEngine;

    public WidgetMachine(InternalCombustionEngine internalCombustionEngine){
        this.internalCombustionEngine = internalCombustionEngine;
        this.selectedEngine = EngineType.INTERNAL_COMBUSTION;
    }

    public WidgetMachine(SteamEngine steamEngine){
        this.steamEngine = steamEngine;
        this.selectedEngine = EngineType.STEAM;
    }
    public BigDecimal produceWidgets(int quantity) {
        BigDecimal cost = BigDecimal.valueOf(0);

        if (selectedEngine.equals(EngineType.INTERNAL_COMBUSTION)){
            internalCombustionEngine.start();
            if (internalCombustionEngine.isRunning()) {
                cost = produce(quantity);
            }
            internalCombustionEngine.stop();
        } else if (selectedEngine.equals(EngineType.STEAM)) {
            steamEngine.start();
            if (steamEngine.isRunning()){
                cost = produce(quantity);
            }
            steamEngine.stop();
        }
        return cost;
    }

    private BigDecimal produce(int quantity) {
        int batch = 0;
        int batchCount = 0;
        BigDecimal costPerBatch = BigDecimal.valueOf(0);

        if (selectedEngine.equals(EngineType.INTERNAL_COMBUSTION)){
            if (internalCombustionEngine.getFuelType() == FuelType.PETROL) {
                costPerBatch = BigDecimal.valueOf(9);
            } else if (internalCombustionEngine.getFuelType() == FuelType.DIESEL) {
                costPerBatch = BigDecimal.valueOf(12);
            }
        } else if (selectedEngine.equals(EngineType.STEAM)) {
            if (steamEngine.getFuelType() == FuelType.COAL){
                costPerBatch = BigDecimal.valueOf(5.65);
            } else if (steamEngine.getFuelType() == FuelType.WOOD) {
                costPerBatch = BigDecimal.valueOf(4.35);
            }
        }

        while (batch < quantity) {
            if (selectedEngine.equals(EngineType.INTERNAL_COMBUSTION)){
                batch += 8;
            } else if (selectedEngine.equals(EngineType.STEAM)) {
                batch += 2;
            }
            batchCount++;
        }
        return costPerBatch.multiply(new BigDecimal(batchCount));
    }


}
