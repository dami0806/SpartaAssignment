package day1_calculator.enumType;

import day1_calculator.ArithmeticCalculator;
import day1_calculator.Calculator;
import day1_calculator.CircleCalculator;

import java.io.BufferedReader;
import java.lang.reflect.InvocationTargetException;

// enum의 각 상수를 class와 연결
public enum CalculationType {
    ARITHMETIC(ArithmeticCalculator.class) {
        @Override
        public Calculator createInstance(BufferedReader br) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
            return new ArithmeticCalculator(br);
        }
    },
    CIRCLE(CircleCalculator.class) {
        @Override
        public Calculator createInstance(BufferedReader br) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
            return new CircleCalculator(br);        }
    };

    // 해당 계산기 클래스를 연결
    private final Class<? extends Calculator> calculatorClass;

    public Class<? extends Calculator> getCalculatorClass() {
        return calculatorClass;
    }

    CalculationType(Class<? extends Calculator> calculatorClass) {
        this.calculatorClass = calculatorClass;
    }

    // 생성자로 사용해서 각 계산기의 인스턴스를 생성
    public abstract Calculator createInstance(BufferedReader br) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;

}
