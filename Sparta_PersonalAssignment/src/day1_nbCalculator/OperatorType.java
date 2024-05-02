package day1_nbCalculator;

import java.util.function.BiFunction;

public enum OperatorType {
    ADD("+", (first, second) -> first.doubleValue() + second.doubleValue()),
    SUBTRACT("-", (first, second) -> first.doubleValue() - second.doubleValue()),

    MULTIPLY("*", (first, second) -> first.doubleValue() * second.doubleValue()),
    DIVIDE("/", (first, second) -> {
        if (second.doubleValue() == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
        return first.doubleValue() / second.doubleValue();
    }),
    MODULO("%", (first, second) -> {
        if (second.doubleValue() == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
        return first.doubleValue() % second.doubleValue();
    });

    private final String operator;
    // private final double operation; -> 람다에서 변한 계산으로
    // ADD("+") {apply함수 -> return double이였음}
    BiFunction<Number, Number, Double> operation;

    OperatorType(String operator, BiFunction<Number, Number, Double> operation) {
        this.operator = operator;
        this.operation = operation;
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
    public double apply(Number firstNumber, Number secondNumber) {
        return operation.apply(firstNumber,secondNumber);
    }
}