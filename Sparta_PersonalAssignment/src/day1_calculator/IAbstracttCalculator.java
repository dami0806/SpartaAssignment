package day1_calculator;

import java.io.IOException;

public interface IAbstracttCalculator {
    // 계산기 실행
    void run() throws IOException;

    // 사용자로부터 입력 받기
    String readInput(String prompt) throws IOException;

    // 숫자 입력 받기
    double getNumber(String prompt) throws IOException;

    // 조회 요청 처리
    void inputInquiry(String prompt) throws IOException;

    // 결과 삭제 처리
    void inputRemove(String prompt) throws IOException;

    // 종료 요청 처리
    boolean inputExit(String prompt) throws IOException;

    // 결과 포맷팅 출력
    void formatResults();
}
