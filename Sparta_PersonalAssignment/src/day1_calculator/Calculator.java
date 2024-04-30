package day1_calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// static 제거: 독립성 고려
public class Calculator {
    private BufferedReader br;

    public Calculator() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() throws IOException {

        String selectType;// "arithmetic"/ "circle"선택
        int firstNumber, secondNumber;

        System.out.println("arithmetic / circle선택하세요");
        selectType = br.readLine();
        switch (selectType) {
            case "arithmetic":
                ArithmeticCalculator ar = new ArithmeticCalculator();
                ar.run();
                break;
            case "circle":
                //circleCalcuator();
                break;
            default:
                break;
        }
    }
}
