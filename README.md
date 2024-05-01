# Sparta_Assignment
### Level 1,2: day1_nbCalculator파일로 확인해주세요

### Level 3 외 리펙토링:  day1_calculator파일로 확인해주세요

---
### Level 1,2: day1_nbCalculator파일 : 클래스와 인터페이스 간의 관계, 메서드 다이어그램
```
App
│
├── handleArithmeticCalculator()
│   ├── inputNumber()
│   ├── inputOperator()
│   └── ArithmeticCalculator
│       ├── calculate()
│       │   └── Operator
│       │       ├── AddOperator
│       │       ├── SubtractOperator
│       │       ├── MultiplyOperator
│       │       └── ModOperator
│       ├── inquiry()
│       └── removeResult()
│
└── handleCircleCalculator()
    ├── inputNumber()
    └── CircleCalculator
        ├── calculate()
        ├── inquiry()
        └── removeResult()

Calculator (abstract)
│
├── addArr(double result)
├── inquiry()
└── removeResult()

ArithmeticCalculator extends Calculator
│
└── calculate() - Operator interface implementations 사용

CircleCalculator extends Calculator
└── calculate() - circle area 계산

Operator (interface)
│
├── AddOperator implements Operator
├── SubtractOperator implements Operator
├── MultiplyOperator implements Operator
└── ModOperator implements Operator

```
