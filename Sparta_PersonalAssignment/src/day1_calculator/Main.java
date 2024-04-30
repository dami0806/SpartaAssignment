package day1_calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
        System.out.println("결과: " + result);
        System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
        System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
        System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Calculator calculator = new Calculator();
        calculator.run();
    }
}
