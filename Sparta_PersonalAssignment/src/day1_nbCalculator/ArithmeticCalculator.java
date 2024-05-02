package day1_nbCalculator;

import java.io.IOException;
import java.util.Optional;

import static day1_nbCalculator.App.br;
import static day1_nbCalculator.App.getInput;

public class ArithmeticCalculator extends Calculator {
    //    private String symbol;
    private OperatorType operatorType;
    private double firstNumber, secondNumber, result;

    public ArithmeticCalculator(String symbol, double firstNumber, double secondNumber) {
        this.operatorType = OperatorType.getFromOperator(symbol);
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
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

    @Override
    public double calculate() throws IOException {
        if ((operatorType == OperatorType.DIVIDE ||
                operatorType == OperatorType.MODULO) &&
                secondNumber == 0) {

            while (this.secondNumber == 0) {
                System.out.println("0이 아닌 두번째 숫자 입력를 다시 입력해주세요:");
                secondNumber = Double.parseDouble(getInput(br));
            }
        }
        result = operatorType.apply(firstNumber, secondNumber);
        addArr(result);
        return result;
    }
}
