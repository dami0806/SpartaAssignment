package day1_nbCalculator;

public class ModOperator implements Operator {
    @Override
    public double operator(double firstNumber, double secondNumber) {
        if (secondNumber == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return firstNumber % secondNumber;
    }
}