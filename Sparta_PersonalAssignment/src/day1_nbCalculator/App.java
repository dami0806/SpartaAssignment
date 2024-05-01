package day1_nbCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class App {
    // 입력값을 객체 생성 기다리지 않고 받기
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer> results = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String symbol;
        int firstNumber, secondNumber, result;
        while(true) {
            System.out.println("첫번째 연산자입력:");
            firstNumber = inputNumber(getInput(br));

            System.out.println("두번째 연산자입력:");
            secondNumber = inputNumber(getInput(br));

            System.out.print("사칙연산 기호를 입력하세요: ");
            symbol = inputOperator(getInput(br));

            result = calculatorResult(firstNumber, secondNumber, symbol);
            addArr(result);
            System.out.println("결과: " + result);
            for (int i : results) {
                System.out.printf("%d ",i);
                System.out.println("");
            }
        }
    }
private static void addArr(int result) {
        if (results.size() >= 10) {
            results.remove(0);
        }
    results.add(result);
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
        while (true) {
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

