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

            app.addArr(result);
            System.out.println("결과: " + result);

            app.removeArr();
            app.inquiry();

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            if (getInput(br).toLowerCase().equals("exit")) {
                break;
            }
        }
    }

    private void inquiry() {
        System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");

        for (int i : results) {
            System.out.printf("%d ", i);
            System.out.println("");
        }
    }

    private void addArr(int result) {
        results.add(result);
    }

    private void removeArr() throws IOException {
        System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
        if (getInput(br).toLowerCase().equals("remove")) {
            if (results.isEmpty()) {
                System.out.println("결과배열이 비어있습니다.");
            }
            results.remove(0);
        }
    }

    private static String getInput(BufferedReader br) throws IOException {
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

//    private int calculatorResult(int first, int second, String symbol) throws IOException {
//        int result = 0;
//        switch (symbol) {
//            case "+":
//                calculator. result = first + second;
//                break;
//            case "-":
//                result = first - second;
//                break;
//            case "*":
//                result = first * second;
//                break;
//            case "/":
//                while (second == 0) {
//                    System.out.println("0이 아닌 두번째 연산자입력를 다시 입력해주세요:");
//                    second = inputNumber(getInput(br));
//                }
//
//                result = first / second;
//                break;
//        }
//        return result;
//    }
}

