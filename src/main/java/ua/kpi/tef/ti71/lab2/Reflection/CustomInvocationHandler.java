package ua.kpi.tef.ti71.lab2.Reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {
    private Object object;
    public  CustomInvocationHandler(Object object) {
        this.object = object;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        Object result = null;
        if (method.getName().startsWith("set")) {
            throw new IllegalAccessException();
        } else if (method.getName().startsWith("get")) {
            result = method.invoke(this.object, args);
        }
        return result;
    }
}

