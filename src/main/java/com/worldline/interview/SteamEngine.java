package com.worldline.interview;

public class SteamEngine extends Engine{

    public SteamEngine(FuelType requiredFuelType) {
        if (requiredFuelType.equals(FuelType.WOOD) || requiredFuelType.equals(FuelType.COAL)){
            this.requiredFuelType = requiredFuelType;
        }else {
            throw new IllegalArgumentException(requiredFuelType + " is not suitable for Steam Engine.");
        }
        running = false;
        fuelLevel = 0;
    }
}
