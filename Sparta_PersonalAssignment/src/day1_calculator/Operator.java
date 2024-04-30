package day1_calculator;

public interface Operator {
    int operator(int firstNumber, int secondNumber);
    String getSymbol();  //연산자
}
