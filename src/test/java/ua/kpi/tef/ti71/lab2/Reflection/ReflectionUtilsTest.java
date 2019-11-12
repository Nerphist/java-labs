package ua.kpi.tef.ti71.lab2.Reflection;

import org.junit.jupiter.api.Test;
import ua.kpi.tef.ti71.lab2.Cars.Car;
import ua.kpi.tef.ti71.lab2.Cars.CarBlueprint;
import ua.kpi.tef.ti71.lab2.Cars.CarBrand;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReflectionUtilsTest {

    @Test
    public void getAllFields() {
        Car car = new Car();
        List<Field> fields1 = ReflectionUtils.getAllFields(car);
        List<Field> fields2 = new LinkedList<Field>();
        Class clazz = car.getClass();
        while (!clazz.equals(Object.class)) {
            fields2.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }
        assertArrayEquals(fields1.toArray(), fields2.toArray());
    }

    @Test
    public void getAllMethods() {
        Car car = new Car();
        List<Method> methods1 = ReflectionUtils.getAllMethods(car);
        List<Method> methods2 = new LinkedList<Method>();
        Class clazz = car.getClass();
        while (!clazz.equals(Object.class)) {
            methods2.addAll(Arrays.asList(clazz.getDeclaredMethods()));
            clazz = clazz.getSuperclass();
        }
        assertArrayEquals(methods1.toArray(), methods2.toArray());
    }

    @Test
    void getProxy(){
        Car car = new Car(CarBrand.TESLA, 0, 370);
        CarBlueprint proxy = (CarBlueprint) ReflectionUtils.getProxy(car);


        assertThrows(Exception.class,
                () -> proxy.setPower(1),
                "No exception");

        assertThrows(Exception.class,
                () -> proxy.setCylinders(1),
                "No exception");

        assertThrows(Exception.class,
                () -> proxy.setBrand(CarBrand.HOMEMADE),
                "No exception");
    }


}