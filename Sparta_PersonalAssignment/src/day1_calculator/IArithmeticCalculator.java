package day1_calculator;

import day1_calculator.enumType.OperatorType;

import java.io.IOException;

public interface IArithmeticCalculator {
    void arithmeticCalcuator() throws IOException;

    OperatorType getOperator(String prompt);
}
