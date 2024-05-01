package day1_calculator;

import day1_calculator.Params.ArithmeticParams;
import day1_calculator.enumType.CalculationType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Optional;

// static 제거: 독립성 고려
public class Calculator extends AbstractCalculator {

    public Calculator(BufferedReader br) {
        super(br);
    }

    @Override
    public void run() throws IOException {
        while (true) {
            System.out.println("arithmetic / circle 선택하세요");
            String selectType = readInput().toLowerCase();
            try {
                // 입력된 문자열을 변수로
                CalculationType type = CalculationType.valueOf(selectType.toUpperCase());
                Optional<Calculator> instance = Optional.ofNullable(type.createInstance(getBr()));
                if (instance.isPresent()) {
                    instance.get().run();
                }
                System.out.println("계산기 인스턴스 생성 실패");
                return;
            }
            catch (IllegalArgumentException e) {
                System.out.println("유효하지 않은 계산기 타입: " + selectType);
            }
            catch (Exception e) {
                System.out.println("유효하지 않은 계산기 타입: " + selectType+ "=> arithmetic / circle 중에서 선택하세요");
            }
        }
    }
}

