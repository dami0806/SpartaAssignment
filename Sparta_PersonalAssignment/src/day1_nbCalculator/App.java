package day1_nbCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    // 입력값을 객체 생성 기다리지 않고 받기
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String symbol;
        int firstNumber, secondNumber, result;
        System.out.println("첫번째 연산자입력:");
        firstNumber = inputNumber(getInput(br));

        System.out.println("두번째 연산자입력:");
        secondNumber = inputNumber(getInput(br));

        System.out.print("사칙연산 기호를 입력하세요: ");
        symbol = inputOperator(getInput(br));

        result = calculatorResult(firstNumber,secondNumber,symbol); // br입력값을 받는 매개변수인데 나중에 선언되어도 되지 않나 왜 얘도 static이여야하는거지
        System.out.println("결과: " + result);

    }

    private static String getInput(BufferedReader br) throws IOException {
        return br.readLine();
    }

    private static int inputNumber(String input) throws IOException {
        while (true) {
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("유효한 숫자를 입력해주세요");
                input = br.readLine();
            }
        }
    }
    private static String inputOperator(String input) throws IOException {
        while(true) {
            if (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/")) {
                return input;
            } else {
                System.out.println("잘못된 연산자입니다. 다시 입력해주세요.");
                input = br.readLine();
            }
        }
    }

    private static int calculatorResult(int first, int second, String symbol) throws IOException {
        int result = 0;
        switch (symbol) {
            case "+":
                result = first + second;
                break;
            case "-":
                result = first - second;
                break;
            case "*":
                result = first * second;
                break;
            case "/":
                while (second == 0) {
                    System.out.println("0이 아닌 두번째 연산자입력를 다시 입력해주세요:");
                    second = inputNumber(getInput(br));
                }

                result = first / second;
                break;
        }
        return result;
    }
}

