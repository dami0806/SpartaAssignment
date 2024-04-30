package day1_calculator;

public enum OperatorType {
    ADD("+") {
        @Override
        double apply(double firstNumber, double secondNumber) {
            return firstNumber + secondNumber;
        }
    },
    SUBTRACT("-") {
        @Override
        double apply(double firstNumber, double secondNumber) {
            return firstNumber - secondNumber;
        }
    },
    MULTIPLY("*") {
        @Override
        double apply(double firstNumber, double secondNumber) {
            return firstNumber * secondNumber;
        }
    },
    DIVIDE("/") {
        @Override
        double apply(double firstNumber, double secondNumber) {
            if (secondNumber == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }
            return firstNumber / secondNumber;
        }
    },
    MODULO("%") {
        @Override
        double apply(double firstNumber, double secondNumber) {
            if (secondNumber == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }
            return firstNumber % secondNumber;
        }
    };

    private String symbol;

    OperatorType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    // 문자열 -> 기호
    public static OperatorType getFromSymbol(String symbol) {
        for (OperatorType operatorType : OperatorType.values()) {
            if (operatorType.getSymbol().equals(symbol)) {
                return operatorType;
            }
        }
        throw new IllegalArgumentException("맞는 연산자를 다시 입력하세요 " + symbol);
    }


    abstract double apply(double firstNumber, double secondNumber);
}
