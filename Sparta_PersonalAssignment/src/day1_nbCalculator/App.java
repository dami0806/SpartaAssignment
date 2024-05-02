package day1_nbCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class App {
    // 입력값을 객체 생성 기다리지 않고 받기
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        App app = new App();

        while (true) {
            System.out.println("계산기를 선택하세요: 1.arithmetic 2.circle (숫자입력)");
            int calculatorType = 0;
            while (true) {
                try {
                    calculatorType = Integer.parseInt(getInput(br));
                    if (calculatorType == 1 || calculatorType == 2) {
                        break;
                    } else {
                        System.out.println("1 또는 2를 입력해주세요.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("유효한 숫자를 입력해주세요.");
                }
            }

            if (calculatorType == 1) {
                app.handleArithmeticCalculator();

            } else if (calculatorType == 2) {
                app.handleCircleCalculator();
            }
            System.out.println("없는 계산기입니다.");
            return;
        }
    }

    private void handleArithmeticCalculator() throws IOException {

        String symbol;
        double firstNumber, secondNumber, result;

        System.out.println(" -- 사칙연산 계산기 -- ");

        while (true) {
            System.out.println("첫번째 연산자입력:");
            firstNumber = inputNumber(getInput(br));

            System.out.println("두번째 연산자입력:");
            secondNumber = inputNumber(getInput(br));

            System.out.print("사칙연산 기호를 입력하세요: ");
            symbol = inputOperator(getInput(br));

            ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator(symbol, firstNumber, secondNumber);
            result = arithmeticCalculator.calculate();
            System.out.printf("연산 결과: %.2f %s %.2f = %.2f\n", firstNumber, symbol, secondNumber, result);

            arithmeticCalculator.inquiry();
            arithmeticCalculator.removeResult();

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            if (getInput(br).toLowerCase().equals("exit")) {
                break;
            }
        }
    }

    private void handleCircleCalculator() throws IOException {

        double radius, result = 0;
        System.out.println(" -- 원의 넓이 계산기 -- ");

        while (true) {
            System.out.println("원의 반지름 입력:");
            radius = inputNumber(getInput(br));

            CircleCalculator circleCalculator = new CircleCalculator(radius);
            result = circleCalculator.calculate();
            System.out.printf("원의 넓이: %.2f * %.2f * ℔ = %.2f\n", radius, radius, result);

            circleCalculator.inquiry();
            circleCalculator.removeResult();

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            if (getInput(br).toLowerCase().equals("exit")) {
                break;
            }
        }
    }

    static String getInput(BufferedReader br) throws IOException {
        return br.readLine();
    }

    private double inputNumber(String input) throws IOException {
        while (true) {
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("유효한 숫자를 입력해주세요");
                input = br.readLine();
            }
        }
    }

    private String inputOperator(String input) throws IOException {
        while (true) {
            if (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/") || input.equals("%")) {
                return input;
            } else {
                System.out.println("잘못된 연산자입니다. 다시 입력해주세요.");
                input = br.readLine();
            }
        }
    }
}