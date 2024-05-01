package day1_calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

// readInput,getNumber..등 메서드 위치 추상클래스와 Calculator클래스 중 고민
// AbstractCalculator: 모든 계산기의 공통적인 기능
// Calculator: 사용자 입력을 통해 인스턴스 생성 및 로직 실행기능
public abstract class AbstractCalculator implements ICalculator {
    private BufferedReader br;
    private ArrayList<Double> results;

    public BufferedReader getBr() {
        return br;
    }

    public void setBr(BufferedReader br) {
        this.br = br;
    }

    public ArrayList<Double> getResults() {
        return results;
    }

    public void setResults(ArrayList<Double> results) {
        this.results = results;
    }

    public AbstractCalculator(BufferedReader br) {
        this.br = br;
        this.results = new ArrayList<>();
    }

    protected String readInput() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException("입력 도중 오류가 발생했습니다.", e);
        }
    }

    protected double getNumber(String prompt) {
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
