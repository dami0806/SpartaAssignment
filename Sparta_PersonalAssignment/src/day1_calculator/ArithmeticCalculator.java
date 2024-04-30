package day1_calculator;

import day1_calculator.enumType.OperatorType;

import java.io.IOException;

public class ArithmeticCalculator extends Calculator {
    private OperatorType operator;
    private double result = 0;
    private String input;

    public ArithmeticCalculator() {
        super();
    }

    public void run() throws IOException {
        arithmeticCalcuator();
    }

    private void arithmeticCalcuator() throws IOException {
        OperatorType operator;
        double firstNumber, secondNumber;
        while (true) {

            firstNumber = getNumber("첫번째 숫자를 입력해주세요");
            secondNumber = getNumber("두번째 숫자를 입력해주세요");
            operator = getOperator("연산자를 입력해주세요 (+, -, *, /, %)");

            if (!calculate(operator, firstNumber, secondNumber)) continue;
            inputInquiry("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            inputRemove("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");

            if (inputExit("더 계산하시겠습니까? (exit 입력 시 종료)")) {
                break;
            }
        }
    }

    // 유효한 정수 받아오기
    double getNumber(String prompt) {
        String number;

        while (true) {
            System.out.println(prompt);
            number = readInput();
            try {
                return parseNumber(number);
            } catch (NumberFormatException e) {
                System.out.println("유효한 숫자가 아닙니다. 다시 입력해주세요.");
            }
        }
    }

    // 입력 읽기
    private String readInput() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException("입력 도중 오류가 발생했습니다.", e);
        }
    }

    // 숫자 파싱
    private double parseNumber(String number) {
        return Double.parseDouble(number);
    }

    // 연산자
    private OperatorType getOperator(String prompt) {
        String operInput;

        while (true) {
            System.out.println(prompt);
            operInput = readInputOperator();
            try {
                return OperatorType.getFromSymbol(operInput);

            } catch (IllegalArgumentException e) {
                    System.out.println("올바른 연산자를 입력해주세요 (+, -, *, /, %):");
            }
        }
    }

    // Operator 받아오기
    private String readInputOperator() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException("입력 도중 오류가 발생했습니다.", e);
        }
    }


    // 예외처리 대신 if문이 제로 디비전에서는 더 효율적으로 보임
    private boolean calculate(OperatorType operator, double firstNumber, double secondNumber) {
        while (true) {
            try {
                result = operator.apply(firstNumber, secondNumber);
                results.add(result);
                System.out.printf("%.2f %s %.2f = %.2f\n", firstNumber, operator.getSymbol(), secondNumber, result);
                return true;
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage() + " 다시 시도해주세요.");
                secondNumber = getNumber("두번째 숫자를 다시 입력해주세요:");
            }
        }
    }
}
