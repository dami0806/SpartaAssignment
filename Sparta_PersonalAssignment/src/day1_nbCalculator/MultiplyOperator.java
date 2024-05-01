package day1_nbCalculator;

public class MultiplyOperator implements Operator {
    @Override
    public double operator(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }
}

