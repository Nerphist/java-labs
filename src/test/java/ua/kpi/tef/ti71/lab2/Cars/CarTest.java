package ua.kpi.tef.ti71.lab2.Cars;

import org.junit.jupiter.api.Test;
import ua.kpi.tef.ti71.lab2.Rules.RoadSign;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    public void canEnterAt_ForbiddenForAll() {
        assertFalse(new Car().canEnterAt(RoadSign.EntryForbiddenForAll));
    }

    @Test
    public void canEnterAt_ForbiddenForMotorcycles() {
        assertTrue(new Car().canEnterAt(RoadSign.EntryForbiddenForMotorcycles));
    }

    @Test
    public void canEnterAt_ForbiddenForTrucks() {
        assertTrue(new Car().canEnterAt(RoadSign.EntryForbiddenForTrucks));
    }

}