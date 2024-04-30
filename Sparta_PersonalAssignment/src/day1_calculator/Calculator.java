package day1_calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Calculator {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static ArrayList<Integer> results = new ArrayList<>();
    private static int result = 0;
    private static String input;

    public static void run() throws IOException {
        String operator;
        int firstNumber, secondNumber;

        while (true) {
            firstNumber = getNumber("첫번째 숫자를 입력해주세요");
            secondNumber = getNumber("두번째 숫자를 입력해주세요");
            operator = getOperator("연산자를 입력해주세요 (+, -, *, /)");

            if (!calculate(operator, firstNumber, secondNumber)) {
                continue; // 실패하면 다시
            }
            inputInquiry("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            inputRemove("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");

            if (inputExit("더 계산하시겠습니까? (exit 입력 시 종료)")) {
                break;
            }
        }
    }

    // 숫자 받아오기
    static int getNumber(String prompt) {
        int number = 0;
        boolean vaild = false;
        while (!vaild) {
            System.out.println(prompt);
            try {
                number = Integer.parseInt(br.readLine());
                vaild = true;
            } catch (NumberFormatException e) {
                System.out.println("유효한 숫자가 아닙니다. 다시 입력해주세요.");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return number;
    }

    static String getOperator(String prompt) throws IOException {
        String operator;
        while (true) {
            System.out.println(prompt);

            operator = br.readLine();
            if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
                break;
            }
            System.out.println("올바른 연산자를 입력해주세요 (+, -, *, /):");
        }
        return operator;
    }

    static boolean calculate(String operator, int firstNumber, int secondNumber) {
        boolean valid = false;
        while (!valid) {
            try {
                switch (operator) {
                    case "+":
                        result = firstNumber + secondNumber;
                        valid = true;
                        break;
                    case "-":
                        result = firstNumber - secondNumber;
                        valid = true;
                        break;
                    case "*":
                        result = firstNumber * secondNumber;
                        valid = true;
                        break;
                    case "/":
                        if (secondNumber == 0) {
                            throw new ArithmeticException("0으로 나눌 수 없습니다.");
                        }
                        result = firstNumber / secondNumber;
                        valid = true;
                        break;
                    default:
                        operator = getOperator("다시 연산자를 입력해주세요 (+, -, *, /):");
                        break;
                }
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
                secondNumber = getNumber("두번째 숫자를 다시 입력해주세요:");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        results.add(result);
        System.out.printf("%d %s %d = %d\n", firstNumber, operator, secondNumber, result);
        return true;
    }

    static void inputInquiry(String promt) throws IOException {
        System.out.println(promt);
        input = br.readLine();
        if (input.equals("inquiry")) {
            System.out.println(results);
        }
    }

    static void inputRemove(String promt) throws IOException {
        System.out.println(promt);
        input = br.readLine();

        if (input.equals("remove")) {
            results.remove(0);
            System.out.println("첫번째 연산 결과를 삭제했습니다");
            System.out.println(results);
        }
    }

    static boolean inputExit(String promt) throws IOException {
        System.out.println(promt);
        input = br.readLine();

        if (input.equals("exit")) {
            return true;
        }
        return false;
    }

}