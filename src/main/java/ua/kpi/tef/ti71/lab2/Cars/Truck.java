package ua.kpi.tef.ti71.lab2.Cars;

import ua.kpi.tef.ti71.lab2.Rules.RoadSign;
import ua.kpi.tef.ti71.lab2.Rules.UsageLimit;

public class Truck extends Car {
    /**
     * Measured in kilos
     */
    @UsageLimit(3500) // Weight more than 3.5 tons is illegal
    private double bearingCapacity;

    public Truck(CarBrand brand, int cylinders, double power, double bearingCapacity) {
        super(brand, cylinders, power);
        this.bearingCapacity = bearingCapacity;
    }

    public Truck(Car car, double bearingCapacity) {
        super(car);
        this.bearingCapacity = bearingCapacity;
    }

    public Truck(Truck truck) {
        super(truck);
        this.bearingCapacity = truck.bearingCapacity;
    }

    public double getBearingCapacity() {
        return bearingCapacity;
    }

    public void setBearingCapacity(double bearingCapacity) {
        this.bearingCapacity = bearingCapacity;
    }

    @Override
    public boolean canEnterAt(RoadSign roadSign) {
        switch (roadSign) {
            case EntryForbiddenForAll:
            case EntryForbiddenForTrucks:
                return false;
            case EntryForbiddenForMotorcycles:
            default:
                return true;
        }
    }

    @Override
    public RoadSign[] getEntryAllowedSigns() {
        return new RoadSign[]{RoadSign.EntryForbiddenForMotorcycles};
    }

    @Override
    public String toString() {
        return super.toString() + "bearing capacity: " + this.bearingCapacity + "kg ";
    }
}
