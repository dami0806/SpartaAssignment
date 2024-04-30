package day1_calculator;

import day1_calculator.Params.ArithmeticParams;

public interface IDetailedCalculator<T> {
    //인터페이스예 계산 메서드를 넣고 싶은데 매개변수가 다름 -> 제너릭, 매개변수를 객체로

    boolean calculate(T param);
}
