package day1_calculator;

import java.lang.reflect.InvocationTargetException;

// enum의 각 상수를 class와 연결
public enum CalculationType {
    ARITHMETIC(ArithmeticCalculator.class),
    CIRCLE(CircleCalculator.class);

    // 해당 계산기 클래스를 연결
    private final Class<? extends Calculator> calculatorClass;

    CalculationType(Class<? extends Calculator> calculatorClass) {
        this.calculatorClass = calculatorClass;
    }
    // 생성자로 사용하여 각 계산기의 인스턴스를 생성
    public Calculator createInstance() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return calculatorClass.getDeclaredConstructor().newInstance();
    }
}
