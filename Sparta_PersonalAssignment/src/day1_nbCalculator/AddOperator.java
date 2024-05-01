package day1_nbCalculator;

public class AddOperator implements Operator {
    @Override
    public double operator(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }
}

