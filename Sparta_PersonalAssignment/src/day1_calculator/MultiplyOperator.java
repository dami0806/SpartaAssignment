package day1_calculator;

public class MultiplyOperator implements Operator {
    @Override
    public int operator(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

    @Override
    public String getSymbol() {
        return "*";
    }
}
