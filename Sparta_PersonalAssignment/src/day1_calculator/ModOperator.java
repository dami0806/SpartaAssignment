package day1_calculator;

public class ModOperator implements Operator {
    @Override
    public int operator(int firstNumber, int secondNumber) {
        if (secondNumber == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return firstNumber % secondNumber;
    }
    @Override
    public String getSymbol() {
        return "%";
    }
}
