package day1_calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CircleCalculator extends Calculator {
    private double radius;

    public CircleCalculator() {
        super();
    }

    public void run() throws Exception {
        arithmeticCalcuator();
    }
    private void arithmeticCalcuator() throws IOException {
        while (true) {
            if (!calculate()) continue;
            inputInquiry("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            inputRemove("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");

            if (inputExit("더 계산하시겠습니까? (exit 입력 시 종료)")) {
                break;
            }
        }
    }

    private double getNumber(String prompt) {
        String number;
        while (true) {
            System.out.println(prompt);
            number = readInput();
            try {
                return Double.parseDouble(number);
            } catch (NumberFormatException e) {
                System.out.println("유효한 숫자가 아닙니다. 다시 입력해주세요.");
            }
        }
    }

    private String readInput() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException("입력 도중 오류가 발생했습니다.", e);
        }
    }

    private boolean calculate() {
        while (true) {
            try {
                radius = getNumber("원의 반지름을 입력해주세요: ");
                System.out.println(resultStr(radius));
                double result = resultvalue(radius);
                results.add(result);

                System.out.printf("원의 넓이는 %.2f입니다.\n", resultvalue(radius));
                return true;
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage() + " 다시 시도해주세요.");
            }
        }


    }

    private double resultvalue(double radius) {
        return radius * radius * Math.PI;
    }

    private String resultStr(double radius) {

        return String.format("%.2f * %.2f * ℔ = %.2f", radius, radius, resultvalue(radius));
    }
}
