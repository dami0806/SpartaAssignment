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
            String selectType = getUserInput("arithmetic / circle 선택하세요");//readInput().toLowerCase();
            if (processCalculate(selectType)) {
                return;
            }
        }
    }

    // 사용자 입력
    private String getUserInput(String promt) {
        return readInput(promt).toLowerCase();
    }

    // 계산기 인스턴스 만듦
    private boolean processCalculate(String selectType) {
        try {
            // 입력된 문자열을 변수로
            CalculationType type = CalculationType.valueOf(selectType.toUpperCase());
            return createCalculate(type);

        } catch (IllegalArgumentException e) {
            System.out.println("유효하지 않은 계산기 타입: " + selectType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println("계산기 생성 중 예외 발생: " + e.getMessage());
        }
        return false;
    }

    // return: 계산기인스턴스 생성
    private boolean createCalculate(CalculationType type) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Optional<Calculator> instance = Optional.ofNullable(type.createInstance(getBr()));
        if (instance.isPresent()) {
            instance.get().run();
            return true;
        }
        System.out.println("계산기 인스턴스 생성 실패");
        return false;
    }
}

