package day1_calculator;

public class AddOperator implements Operator {
    @Override
    public double operator(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    @Override
    public String getSymbol() {
        return "+";
    }
}
