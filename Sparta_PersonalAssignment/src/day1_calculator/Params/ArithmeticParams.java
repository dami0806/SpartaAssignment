package day1_calculator.Params;

import day1_calculator.enumType.OperatorType;

public class ArithmeticParams {
    private OperatorType operator;
    private double firstNumber;
    private double secondNumber;

    public OperatorType getOperator() {
        return operator;
    }

    public void setOperator(OperatorType operator) {
        this.operator = operator;
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public ArithmeticParams(OperatorType operator, double firstNumber, double secondNumber) {
        this.operator = operator;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }
}
