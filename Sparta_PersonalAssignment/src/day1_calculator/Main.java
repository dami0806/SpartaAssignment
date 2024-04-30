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

        Interface,상속 추가

       7. Calculator 클래스에 반지름을 매개변수로 전달받아 원의 넓이를 계산하여 반환해주는 메서드를 구현합니다.
    -  사칙연산을 진행할지 원의 넓이를 구할지 명령어를 입력 받은 후 원의 넓이를 구하는 것을 선택했을 때 원의 반지름을 입력 받아 원의 넓이를 구한 후 출력되도록 구현합니다.

    - 원의 넓이 결과를 저장하는 컬렉션 타입의 필드 선언 및 생성
        - 계산된 원의 넓이를 저장합니다.
        - 생성자로 초기화됩니다.
        - 외부에서 직접 접근할 수 없습니다.
        - Getter, Setter 메서드를 구현합니다.
        - 원의 넓이 결과값들을 조회하는 메서드를 구현합니다.

        Enum
        제네릭스
        람다 & 스트림

 */
public class Main {
    public static void main(String[] args) throws Exception {

        Calculator calculator = new Calculator();
        calculator.run();

    }
}
