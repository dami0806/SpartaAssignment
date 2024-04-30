package day1_calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// static 제거: 독립성 고려
public class Calculator {
    protected BufferedReader br;
    protected ArrayList<Double> results;
    public Calculator() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.results = new ArrayList<>();
    }

    public void run() throws Exception {

        String selectType;// "arithmetic"/ "circle"선택

        System.out.println("arithmetic / circle 선택하세요");
        selectType = br.readLine();
        switch (selectType) {
            case "arithmetic":
                ArithmeticCalculator ar = new ArithmeticCalculator();
                ar.run();
                break;
            case "circle":
                CircleCalculator c = new CircleCalculator();
                c.run();
                break;
            default:
                break;
        }
    }

    protected void inputInquiry(String promt) throws IOException {
        System.out.println(promt);
        String input = br.readLine();
        if (input.equals("inquiry")) {
            System.out.println(results);
        }
    }

    protected void inputRemove(String promt) throws IOException {
        System.out.println(promt);
        String input = br.readLine();

        if (input.equals("remove")) {
            results.remove(0);
            System.out.println("첫번째 연산 결과를 삭제했습니다");
            System.out.println(results);
        }
    }

    protected boolean inputExit(String promt) throws IOException {
        System.out.println(promt);
        String input = br.readLine();

        if (input.equals("exit")) {
            return true;
        }
        return false;
    }
}

