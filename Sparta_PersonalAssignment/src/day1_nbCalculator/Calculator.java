package day1_nbCalculator;

public class Calculator {
    private int add(int first, int second) {
        return first + second;
    }

    private int subtract(int first, int second) {
        return first - second;
    }

    private int multiply(int first, int second) {
        return first * second;
    }

    private int divide(int first, int second) {
        if (second == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return first / second;
    }

    public int calculate(int first, int second, String operator) {
        int result = 0;
        switch (operator) {
            case "+":
                result = add(first, second);
                break;

            case "-":
                result = subtract(first, second);
                break;

            case "*":
                result =  multiply(first, second);
                break;

            case "/":
                while (second == 0) {
                    System.out.println("0이 아닌 두번째 연산자입력를 다시 입력해주세요:");
                }
                result = divide(first, second);
                break;

            default:
                throw new IllegalArgumentException("유효하지 않은 연산자입니다.");
        }
        return result;

    }
}
