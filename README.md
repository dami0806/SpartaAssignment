# Sparta_Assignment
### Level 1,2: day1_nbCalculator파일로 확인해주세요

### Level 3 외 리펙토링:  day1_calculator파일로 확인해주세요

---
### Level 1,2: day1_nbCalculator파일 : 클래스와 인터페이스 간의 관계, 메서드 다이어그램

## Level 1 
- 변수 & 타입 이해하기
- 연산자 이해하기
- 제어문 & 반복문 이해하기
- 배열 & 컬렉션 이해하기
```
[main]
  |---[getInput] (숫자 입력)
  |---[inputNumber] (입력 검증 및 정수 변환)
  |---[getInput] (숫자 입력)
  |---[inputNumber] (입력 검증 및 정수 변환)
  |---[getInput] (연산자 입력)
  |---[inputOperator] (연산자 검증)
  |---[calculatorResult] (계산 수행)
  |---[addArr] (결과 저장)
  |---[inquiry] (결과 조회)
  |---[removeArr] (결과 삭제)
```


## Level 2

- 클래스 & 메서드 이해하기
- 생성자 & 접근 제어자 이해하기
- static & final 이해하기
- 상속(&포함) & 다형성 이해하기
- Exception & 예외처리 이해하기
  
```
Calculator 클래스를 활용하여 ArithmeticCalculator, CircleCalculator 클래스를 구현 (상속)
App.main()
  |
  |---> handleArithmeticCalculator()
  |       |---> inputNumber()
  |       |---> inputOperator()
  |       |---> ArithmeticCalculator.calculate() // Calculator
  |             |---> add(), subtract(), multiply(), divide()
  |       |---> ArithmeticCalculator.inquiry() // Calculator
  |       |---> ArithmeticCalculator.removeResult() // Calculator
  |
  |---> handleCircleCalculator()
          |---> inputNumber() 
          |---> CircleCalculator.calculate() // Calculator
          |---> CircleCalculator.inquiry() // Calculator
          |---> CircleCalculator.removeResult() // Calculator

Calculator (abstract)
│
├── addArr(double result)
├── inquiry()
└── removeResult()
```
operator 추가
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
