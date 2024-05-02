package day1_nbCalculator;

public enum OperatorType {
    ADD("+") {
        @Override
        public Number apply(Number firstNumber, Number secondNumber) {
            // Number 타입을 적절하게 처리하기 위한 예제 로직
            return firstNumber.doubleValue() + secondNumber.doubleValue();
        }
    },
    SUBTRACT("-") {
        @Override
        public Number apply(Number firstNumber, Number secondNumber) {
            return firstNumber.doubleValue() - secondNumber.doubleValue();
        }
    },
    MULTIPLY("*") {
        @Override
        public Number apply(Number firstNumber, Number secondNumber) {
            return firstNumber.doubleValue() * secondNumber.doubleValue();
        }
    },
    DIVIDE("/") {
        @Override
        public Number apply(Number firstNumber, Number secondNumber) {
            if (secondNumber.doubleValue() == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }
            return firstNumber.doubleValue() / secondNumber.doubleValue();
        }
    },
    MODULO("%") {
        @Override
        public Number apply(Number firstNumber, Number secondNumber) {
            if (secondNumber.doubleValue() == 0) {
                throw new ArithmeticException("0으로 나눌수 없습니다.");
            }
            return firstNumber.doubleValue() % secondNumber.doubleValue();
        }
    };

    private final String operator;

    OperatorType(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    // static으로, arithmetic에서 enum사용할때 기호로 접근
    public static OperatorType getFromOperator(String operatorSymbol) {
        // 변수
        for (OperatorType operatorType : values()) {
            if (operatorType.getOperator().equals(operatorSymbol)) {
                return operatorType;
            }
        }
        // return 상수
        throw new IllegalArgumentException("올바른 연산자가 아닙니다");
    }

    public abstract Number apply(Number firstNumber, Number secondNumber);
}