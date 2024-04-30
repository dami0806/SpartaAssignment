package day1_calculator;

import day1_calculator.Params.ArithmeticParams;
import day1_calculator.enumType.CalculationType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

// static 제거: 독립성 고려
public class Calculator extends AbstractCalculator {


    public Calculator(BufferedReader br) {
        super(br);
    }

    @Override
    public void run() throws IOException {
        while (true) {
            System.out.println("arithmetic / circle 선택하세요");
            String selectType = br.readLine().toLowerCase();
            try {
                // 입력된 문자열을 변수로
                CalculationType type = CalculationType.valueOf(selectType.toUpperCase());
                Calculator instance = type.createInstance(br);
                instance.run();
                return;
            } catch (IllegalArgumentException | NoSuchMethodException | InvocationTargetException |
                     InstantiationException | IllegalAccessException e) {
                System.out.println("유효하지 않은 계산기 타입입니다.");
            }
        }
    }


}

