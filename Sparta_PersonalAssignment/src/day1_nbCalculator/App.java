package day1_nbCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class App {
    // 입력값을 객체 생성 기다리지 않고 받기
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<Integer> results = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Calculator calculator = new Calculator();
        App app = new App();

        String symbol;
        int firstNumber, secondNumber, result;
        while (true) {
            System.out.println("첫번째 연산자입력:");
            firstNumber = app.inputNumber(getInput(br));

            System.out.println("두번째 연산자입력:");
            secondNumber = app.inputNumber(getInput(br));

            System.out.print("사칙연산 기호를 입력하세요: ");
            symbol = app.inputOperator(getInput(br));

            result = calculator.calculate(firstNumber, secondNumber, symbol);

            calculator.addArr(result);
            System.out.println("결과: " + result);

            calculator.removeArr();
            calculator.inquiry();

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            if (getInput(br).toLowerCase().equals("exit")) {
                break;
            }
        }
    }

    static String getInput(BufferedReader br) throws IOException {
        return br.readLine();
    }

    private int inputNumber(String input) throws IOException {
        while (true) {
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("유효한 숫자를 입력해주세요");
                input = br.readLine();
            }
        }
    }

    private String inputOperator(String input) throws IOException {
        while (true) {
            if (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/")) {
                return input;
            } else {
                System.out.println("잘못된 연산자입니다. 다시 입력해주세요.");
                input = br.readLine();
            }
        }
    }
}