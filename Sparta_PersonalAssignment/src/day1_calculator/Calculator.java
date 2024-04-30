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

    // 조회하기
    protected void inputInquiry(String promt) throws IOException {
        System.out.println(promt);
        String input = br.readLine();

        if (input.equalsIgnoreCase("inquiry")) {

            //포멧팅
            formatResults();
        }
    }

    // 삭제하기
    protected void inputRemove(String promt) throws IOException {
        System.out.println(promt);
        String input = br.readLine();

        if (input.equalsIgnoreCase("remove")) {

            if (results.isEmpty()) {
                System.out.println("삭제할 결과가 없습니다.");
                return;
            }
            results.remove(0);
            System.out.println("첫번째 연산 결과를 삭제했습니다");
            formatResults();
        }
    }

    // 끝내기
    protected boolean inputExit(String promt) throws IOException {
        System.out.println(promt);
        String input = br.readLine();

        if (input.equalsIgnoreCase("exit")) {
            return true;
        }
        return false;
    }

    // 결과 포멧팅
    private void formatResults() {
        results.forEach(result -> System.out.printf("%.2f\n", result));
    }

}

