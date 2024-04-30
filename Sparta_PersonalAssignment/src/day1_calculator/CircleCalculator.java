package day1_calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CircleCalculator {
    BufferedReader br;
    private double radius;

    public CircleCalculator() {

        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() throws Exception {
        calcultate();
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

    private boolean calcultate() {
        while(true) {
            try{
                radius = getNumber("원의 반지름을 입력해주세요: ");
                System.out.println(resultStr(radius));
                System.out.printf("원의 넓이는 %.2f입니다.\n",resultvalue(radius));
                return true;
            }
            catch (ArithmeticException e) {
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
