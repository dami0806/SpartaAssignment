package day1_calculator;

public interface Operator {
    double operator(double firstNumber, double secondNumber);
    String getSymbol();  //연산자
}
