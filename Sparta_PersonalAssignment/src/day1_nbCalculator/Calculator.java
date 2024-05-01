package day1_nbCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import static day1_nbCalculator.App.br;
import static day1_nbCalculator.App.getInput;

public class Calculator {
    /* 연산 결과를 저장하는 컬렉션 타입 필드를 외부에서 직접 접근 하지 못하도록 수정*/
    ArrayList<Integer> results = new ArrayList<>();
    private String symbol;
    private int firstNumber, secondNumber, result;

    // getter setter
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }


    // 연산 메서드
    private int add(int first, int second) {
        return first + second;
    }

    private int subtract(int first, int second) {
        return first - second;
    }

    private int multiply(int first, int second) {
        return first * second;
    }

    private int divide(int first, int second) {
        if (second == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return first / second;
    }

    public void inquiry() {
        System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");

        for (int i : results) {
            System.out.printf("%d ", i);
            System.out.println("");
        }
    }

    public void addArr(int result) {
        results.add(result);
    }

    public void removeArr() throws IOException {
        System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
        if (getInput(br).toLowerCase().equals("remove")) {
            if (results.isEmpty()) {
                System.out.println("결과배열이 비어있습니다.");
            }
            results.remove(0);
        }
    }

    public int calculate(int first, int second, String operator) throws IOException {

        int result = 0;
        switch (operator) {
            case "+":
                result = add(first, second);
                break;

            case "-":
                result = subtract(first, second);
                break;

            case "*":
                result =  multiply(first, second);
                break;

            case "/":
                while (second == 0) {
                    System.out.println("0이 아닌 두번째 연산자입력를 다시 입력해주세요:");
                    second = Integer.parseInt(getInput(br));
                }
                result = divide(first, second);
                break;

            default:
                throw new IllegalArgumentException("유효하지 않은 연산자입니다.");
        }
        return result;

    }
}
