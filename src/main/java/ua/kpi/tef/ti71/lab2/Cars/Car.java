package ua.kpi.tef.ti71.lab2.Cars;

import ua.kpi.tef.ti71.lab2.Rules.LegallyBinding;
import ua.kpi.tef.ti71.lab2.Rules.RoadSign;
import ua.kpi.tef.ti71.lab2.Rules.UsageLimit;

public class Car implements CarBlueprint {
    /**
     * Car brand
     */
    private CarBrand brand;
    /**
     * Describes an amount of cylinders in car engine
     */
    private int cylinders;
    /**
     * Measured in horsepower
     */
    @UsageLimit(500) // Car cannot use more than 500 horsepower
    private double power;

    public Car(CarBrand brand, int cylinders, double power) {
        this.brand = brand;
        this.cylinders = cylinders;
        this.power = power;
    }

    public Car(Car car) {
        this.brand = car.brand;
        this.cylinders = car.cylinders;
        this.power = car.power;
    }

    public Car() {
        this.brand = CarBrand.HOMEMADE;
        this.cylinders = 2;
        this.power = 100;
    }

    public CarBrand getBrand() {
        return brand;
    }

    public void setBrand(CarBrand brand) {
        this.brand = brand;
    }

    public int getCylinders() {
        return cylinders;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    @LegallyBinding
    public boolean canEnterAt(RoadSign roadSign) {
        switch (roadSign) {
            case EntryForbiddenForAll:
                return false;
            case EntryForbiddenForMotorcycles:
            case EntryForbiddenForTrucks:
            default:
                return true;
        }
    }

    @LegallyBinding
    public RoadSign[] getEntryAllowedSigns() {
        return new RoadSign[]{RoadSign.EntryForbiddenForMotorcycles, RoadSign.EntryForbiddenForTrucks};
    }


    public boolean morePowerfulThan(Car car){
        return this.power > car.power;
    }

    @Override
    public String toString() {
        return "Brand: " + this.brand + " cylinders: " + this.cylinders + " power: " + this.power + "hp ";
    }
}
