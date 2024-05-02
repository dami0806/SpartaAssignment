package day1_nbCalculator;

import java.io.IOException;
import java.util.Optional;

import static day1_nbCalculator.App.br;
import static day1_nbCalculator.App.getInput;

public class ArithmeticCalculator extends Calculator {
    //    private String symbol;
    private OperatorType operatorType;
    private Number firstNumber, secondNumber;
    private double result;

    public ArithmeticCalculator(String symbol, Number firstNumber, Number secondNumber) {
        this.operatorType = OperatorType.getFromOperator(symbol);
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public Number getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(Number firstNumber) {
        this.firstNumber = firstNumber;
    }

    public Number getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(Number secondNumber) {
        this.secondNumber = secondNumber;
    }

    @Override
    public double calculate() throws IOException {
        if ((operatorType == OperatorType.DIVIDE ||
                operatorType == OperatorType.MODULO) &&
                secondNumber.doubleValue() == 0.0) {

            while (this.secondNumber.doubleValue() == 0.0) {
                System.out.println("0이 아닌 두번째 숫자 입력를 다시 입력해주세요:");
                secondNumber = Double.parseDouble(getInput(br));
            }
        }
        result = operatorType.apply(firstNumber, secondNumber).doubleValue();
        addArr(result);
        return result;
    }
}
