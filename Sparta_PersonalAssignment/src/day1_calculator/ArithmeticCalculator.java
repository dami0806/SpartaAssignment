package day1_calculator;

import day1_calculator.Params.ArithmeticParams;
import day1_calculator.enumType.OperatorType;
import day1_calculator.interfaces.IArithmeticCalculator;
import day1_calculator.interfaces.IDetailedCalculator;

import java.io.BufferedReader;
import java.io.IOException;

public class ArithmeticCalculator extends Calculator implements IArithmeticCalculator, IDetailedCalculator<ArithmeticParams> {
    private OperatorType operator;
    private double result = 0;
    private String input;

    public ArithmeticCalculator(BufferedReader br) {
        super(br);
    }

    @Override
    public void run() throws IOException {
        ArithmeticParams params;
        arithmeticCalcuator();
    }

    // Operator 받아오기

    // 예외처리 대신 if문이 제로 디비
    // 전에서는 더 효율적으로 보임
    @Override
    public boolean calculate(ArithmeticParams params) {
        while (true) {
            try {
                double firstNumber = params.getFirstNumber();
                double secondNumber = params.getSecondNumber();

                result = operator.apply(firstNumber, secondNumber);
                getResults().add(result);

                System.out.printf(resultStr(params));
                return true;
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage() + "다시 시도해주세요.");
                params.setSecondNumber(getNumber("두번째 숫자를 다시 입력해주세요:"));
                params.setOperator(getOperator("연산자도 다시 입력해주세요:"));
            }
        }
    }

    @Override
    public String resultStr(ArithmeticParams param) {
        return String.format("%.2f %s %.2f = %.2f\n", param.getFirstNumber(), operator.getSymbol(), param.getSecondNumber(), result);
    }

    // imple IArithmetic

    public void arithmeticCalcuator() throws IOException {
        double firstNumber, secondNumber;
        while (true) {

            firstNumber = getNumber("첫번째 숫자를 입력해주세요");
            secondNumber = getNumber("두번째 숫자를 입력해주세요");
            operator = getOperator("연산자를 입력해주세요 (+, -, *, /, %)");
            // ArithmeticParams 객체 생성
            ArithmeticParams arithmeticParams = new ArithmeticParams(operator, firstNumber, secondNumber);

            if (!calculate(arithmeticParams)) continue;

            inputInquiry("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            inputRemove("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");

            if (inputExit("더 계산하시겠습니까? (exit 입력 시 종료)")) {
                break;
            }
        }
    }

    @Override
    // 연산자
    public OperatorType getOperator(String prompt) {
        String operInput;

        while (true) {
            operInput = readInput(prompt);
            try {
                return OperatorType.getFromSymbol(operInput);

            } catch (IllegalArgumentException e) {
                System.out.println("올바른 연산자를 입력해주세요 (+, -, *, /, %):");
            }
        }
    }
}
