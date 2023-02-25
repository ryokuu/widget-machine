package com.worldline.interview;

public class InternalCombustionEngine extends Engine{

    public InternalCombustionEngine(FuelType requiredFuelType) {
        if (requiredFuelType.equals(FuelType.DIESEL) || requiredFuelType.equals(FuelType.PETROL)){
            this.requiredFuelType = requiredFuelType;
        }else {
            throw new IllegalArgumentException(requiredFuelType + " is not suitable for Internal Combustion Engine.");
        }
        running = false;
        fuelLevel = 0;
    }

}
