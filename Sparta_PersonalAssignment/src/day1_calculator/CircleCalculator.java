package day1_calculator;

import day1_calculator.Params.ArithmeticParams;
import day1_calculator.Params.CircleParams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CircleCalculator extends Calculator implements ICircleCalculator, IDetailedCalculator<CircleParams>{

    public CircleCalculator(BufferedReader br) {
        super(br);
    }

    @Override
    public void run() throws IOException {
        CircleParams params;
        circleCalculator();
    }

    @Override
    public boolean calculate(CircleParams params) {
        while (true) {
            double radius;
            try {
                radius = params.getRadius();
                System.out.println(resultStr(params));
                double result = resultvalue(radius);
                getResults().add(result);

                System.out.printf("원의 넓이는 %.2f입니다.\n", resultvalue(radius));
                return true;
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage() + " 다시 시도해주세요.");
            }
        }
    }

    // ICircleCalculator
    @Override
    public void circleCalculator() throws IOException {
        while (true) {
            double radius;
            radius = getNumber("원의 반지름을 입력하세요: ");

            CircleParams circleParams = new CircleParams(radius);
            if (!calculate(circleParams)) continue;
            inputInquiry("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            inputRemove("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");

            if (inputExit("더 계산하시겠습니까? (exit 입력 시 종료)")) {
                break;
            }
        }
    }


    @Override
    public double resultvalue(double radius) {
        return radius * radius * Math.PI;
    }

    @Override
    public String resultStr(CircleParams param) {
        return String.format("%.2f * %.2f * ℔ = %.2f", param.getRadius(), param.getRadius(), resultvalue(param.getRadius()));
    }

}
