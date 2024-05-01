package day1_nbCalculator;

public interface Operator {
    double operator(double firstNumber, double secondNumber);

    String getSymbol();  //연산자
}

