package ua.kpi.tef.ti71.lab6;

import ua.kpi.tef.ti71.lab6.entity.LanguageTest;
import ua.kpi.tef.ti71.lab6.entity.MathTest;
import ua.kpi.tef.ti71.lab6.entity.Test;

import java.util.Random;

public class TestFabric {

    private static final Random RANDOM = new Random();

    public Test getTestByName(String testName) {
        switch (testName) {
            case "Math":
                return new MathTest(RANDOM.nextInt(4) + 1,
                        RANDOM.nextInt(10) + 5, MathTest.MathSphere.Algebra);
            case "Language":
                return new LanguageTest(RANDOM.nextInt(4) + 1,
                        RANDOM.nextInt(10) + 5, "English");
            default:
                throw new IllegalArgumentException();
        }
    }
}
