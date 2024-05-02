package day1_nbCalculator;

public interface GenericOperator<T extends Number> {
    T apply(T firstNumber, T secondNumber);
}
