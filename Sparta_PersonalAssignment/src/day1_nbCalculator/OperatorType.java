package day1_nbCalculator;

public enum OperatorType {
    ADD("+") {
        @Override
        public double apply(double firstNumber, double secondNumber) {
            return firstNumber + secondNumber;
        }
    },

    SUBTRACT("-") {
        @Override
        public double apply(double firstNumber, double secondNumber) {
            return firstNumber - secondNumber;
        }
    },

    MULTIPLY("*") {
        @Override
        public double apply(double firstNumber, double secondNumber) {
            return firstNumber * secondNumber;
        }
    },


    DIVIDE("/") {
        @Override
        public double apply(double firstNumber, double secondNumber) {
            if (secondNumber == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다");
            }
            return firstNumber / secondNumber;
        }
    },

    MODULO("%") {
        @Override
        public double apply(double firstNumber, double secondNumber) {
            if (secondNumber == 0) {
                throw new ArithmeticException("0으로 나눌수 없습니다.");
            }
            return firstNumber % secondNumber;
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

    public abstract double apply(double firstNumber, double secondNumber);

}