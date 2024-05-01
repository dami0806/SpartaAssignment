package day1_nbCalculator;

import java.io.IOException;
import java.util.Optional;

import static day1_nbCalculator.App.br;
import static day1_nbCalculator.App.getInput;

public class ArithmeticCalculator extends Calculator {
    private String symbol;
    private Operator operator;
    private double firstNumber, secondNumber, result;

    public ArithmeticCalculator(String symbol, double firstNumber, double secondNumber) {
        this.symbol = symbol;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    // getter setter
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
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

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }


    // 연산 메서드
    private double add(double first, double second) {
        return first + second;
    }

    private double subtract(double first, double second) {
        return first - second;
    }

    private double multiply(double first, double second) {
        return first * second;
    }

    private double divide(double first, double second) {
        if (second == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return first / second;
    }

    @Override
    public double calculate() throws IOException {

//        double result = 0;
        switch (this.symbol) {
            case "+":
                operator = new AddOperator();
                break;

            case "-":
                operator = new SubtractOperator();
                break;

            case "*":
                operator = new MultiplyOperator();
                break;

            case "/":
                while (this.secondNumber == 0) {
                    System.out.println("0이 아닌 두번째 숫자 입력를 다시 입력해주세요:");
                    this.secondNumber = Double.parseDouble(getInput(br));
                }
                operator = new DivideOperator();
            break;
            case "%":
                while (this.secondNumber == 0) {
                    System.out.println("0이 아닌 두번째 숫자 입력를 다시 입력해주세요:");
                    this.secondNumber = Double.parseDouble(getInput(br));
                }
                operator = new ModOperator();
                break;

            default:
                throw new IllegalArgumentException("유효하지 않은 연산자입니다.");
        }
        result = operator.operator(firstNumber,secondNumber);
        addArr(result);
        return result;
    }
}
