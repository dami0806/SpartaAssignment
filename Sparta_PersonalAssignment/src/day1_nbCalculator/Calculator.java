package day1_nbCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import static day1_nbCalculator.App.br;
import static day1_nbCalculator.App.getInput;

public abstract class Calculator {
    static ArrayList<Double> results = new ArrayList<>();

    public abstract double calculate() throws IOException;

    public void printResult() {
        System.out.println("Result: " + results);
    }

    public void inquiry() throws IOException {
        System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");

        if (getInput(br).equalsIgnoreCase("inquiry")) {
            for (double result : results) {
                System.out.printf("%.2f \n", result);
            }
        }
    }

    public void addArr(double result) {
        results.add(result);
    }

    public void removeResult() throws IOException {
        System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
        if (getInput(br).toLowerCase().equals("remove")) {
            if (results.isEmpty()) {
                System.out.println("결과배열이 비어있습니다.");
            }
            results.remove(0);
            for (double result : results) {
                System.out.printf("%.2f \n", result);
            }
        }
    }
}
