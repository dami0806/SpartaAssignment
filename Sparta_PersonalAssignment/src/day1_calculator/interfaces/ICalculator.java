package day1_calculator.interfaces;

import day1_calculator.enumType.CalculationType;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public interface ICalculator {
    void run() throws IOException;

    boolean processCalculate(String selectType);

    boolean createCalculate(CalculationType type) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException;
}
