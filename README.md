### Level 1,2,3: day1_nbCalculator파일로 확인해주세요
---

| **시스템 이름**          | **기능**                                 | **학습 목표**                                                              | **CS개념 설명 링크**                                              |
|----------------------|---------------------------------------|-------------------------------------------|------------------------------------------------------------|
| **1. 계산기**                |    사칙연산, 원의 둘레 계산       |  [계산기 학습 목표](https://github.com/dami0806/SpartaAssignment/blob/main/README.md#%EA%B3%84%EC%82%B0%EA%B8%B0)                            |  [계산기 진행 중 개념 설명](https://github.com/dami0806/SpartaAssignment/blob/main/README.md#%EA%B3%84%EC%82%B0%EA%B8%B0)       |
| **2. 학생관리시스템**    |     학생 정보 관리, 성적 관리 | [학생관리시스템 학습 목표 ](https://github.com/dami0806/SpartaAssignment?tab=readme-ov-file#%ED%95%99%EC%83%9D%EA%B4%80%EB%A6%AC-%EC%8B%9C%EC%8A%A4%ED%85%9C)                              | [**학생관리시스템프로젝트 진행 중 개념**](https://github.com/dami0806/SpartaAssignment?tab=readme-ov-file#2-student-management-system)|

---
## 💡 학습목표

### 계산기  

- Level 1
  - 변수 & 타입 이해하기
  - 연산자 이해하기
  - 제어문 & 반복문 이해하기
  - 배열 & 컬렉션 이해하기

- Level 2

  - 클래스 & 메서드 이해하기
  - 생성자 & 접근 제어자 이해하기
  - static & final 이해하기
  - 상속(&포함) & 다형성 이해하기
  - Exception & 예외처리 이해하기


- Level 3
  - Enum 이해하기
  - 제네릭스 이해하기
  - 람다 & 스트림 이해하기
---

### 학생관리 시스템
| 기능                    | 화면                                             | 화면 설명 |  기술 설명 |
|-------------------------|--------------------------------------------------|-----------|------------|
| 메인화면                | <img width="60%" alt="image" src="https://github.com/dami0806/SpartaAssignment/assets/85047035/e610952a-46dd-451e-b1bc-6b238e614709"> | 사용자 인터페이스 구성 <br>초기화,네비게이션 | 이벤트 리스너를 통한<br> 동적 화면 전환<br> 및 사용자 인터페이스 관리를<br> 중심으로 구현.|
| 수강생 관리             | <img width="50%" alt="image" src="https://github.com/dami0806/SpartaAssignment/assets/85047035/1de31a9a-e973-443e-a8f1-c471ae2ecd11"> | 수강생 관리의 주요 기능들을<br> 나타내는 화면 | `HashMap`으로 수강생 데이터를<br> 동적으로 관리하고 CRUD 기능 제공. |
| 수강생 등록             | <img width="60%" alt="image" src="https://github.com/dami0806/SpartaAssignment/assets/85047035/305f492e-e400-47e0-a395-6d438733df8d"> | 새로운 수강생을 등록하는 화면 | 새로운 수강생을 등록하는 화면 | 싱글톤 패턴을 사용한 `IDGenerator`로 <br>안정적인 ID 할당과 관리.<br> 입력 데이터 유효성 검증 후<br> `HashMap`을 통해 데이터 저장. |
| 등록 실패               | <img width="60%" alt="image" src="https://github.com/dami0806/SpartaAssignment/assets/85047035/5d8c3fc2-2f32-4965-941a-3b26ca08be9e"> | 필수과목을 제대로 선택하지 않았을 때의 등록 실패 화면 | 사용자 입력에 대한<br> 상세 검증 로직을<br> 통해 유효하지 않은<br> 입력시 명확한 오류 메시지 제공. |
| 등록 성공               | <img width="60%" alt="image" src="https://github.com/dami0806/SpartaAssignment/assets/85047035/56b6f950-9f25-4656-b2b2-fb9ab1610d05"> | 수강생이 제대로 등록된 화면 | 데이터 검증 후<br> 성공적인 등록 정보 저장과 <br>동시에 사용자에게<br> 성공 피드백 제공. |
| 정보 수정               | <img width="60%" alt="image" src="https://github.com/dami0806/SpartaAssignment/assets/85047035/4033f62b-ec35-405b-a420-5570a4ed5424"> | 수강생의 이름을 변경하는 화면 | 선택된 수강생의 <br>정보를 수정하고, <br>변경사항을 <br>`HashMap`에 즉시 반영. |
| 목록 조회               | <img width="50%" alt="image" src="https://github.com/dami0806/SpartaAssignment/assets/85047035/494de4e6-1e0d-4bb0-9691-4555659e2dd9"> | 정보 수정 후 변경된 목록을 보여주는 화면 | `HashMap`을 통한<br> 저장된 수강생 정보의<br> 효율적 조회 및 출력,<br> 대용량 데이터 처리를 위한 최적화. |
| 수강생 삭제             | <img width="60%" alt="image" src="https://github.com/dami0806/SpartaAssignment/assets/85047035/6f264831-4061-4dde-bb32-c6f10f586d89">  | 특정 수강생(예: 1번)을 삭제하는 화면 | 특정 수강생 정보 삭제 및 <br>`IDGenerator`를 이용해 <br>해제된 ID를 재사용 목록에 추가,<br> 데이터 일관성 유지. |
| 수강생 추가 후 ID 재사용 | <img width="50%" alt="image" src="https://github.com/dami0806/SpartaAssignment/assets/85047035/ecea3f26-d536-4e08-b882-bce790e0e3f3"> <img width="50%" alt="image" src="https://github.com/dami0806/SpartaAssignment/assets/85047035/b7fb4452-8ccc-401f-8923-070d6fd9b0ce"> | 삭제된 ID를 재사용하여 새 수강생을 추가하는 화면 | `IDGenerator`에서 관리하는 <br>재사용 가능한 <br>ID 목록(`TreeSet`)을<br> 활용하여 효율적인 리소스 관리 및 데이터 할당. |
| **점수 관리**           | **점수 관리 실행 중**                          | **점수 관리에 관련된 다양한 활동을 보여주는 화면** |
| 점수 등록               | <img width="60%" alt="image" src="https://github.com/dami0806/SpartaAssignment/assets/85047035/59d2f26a-52fa-4072-913d-33873b170a2b"> | 과목 선택 후 점수를 등록하는 화면과 추가 입력이 필요한 문구가 보이는 화면 | 과목별 세션 점수를 <br>`HashMap`으로 관리,<br> 입력 받은 점수의 범위 검증 <br>및 특정 과목의 세션에 점수 저장. |
| 다음 점수 등록          | <img width="50%" alt="image" src="https://github.com/dami0806/SpartaAssignment/assets/85047035/49f31bf6-e999-48f4-9578-f1c0575f4310"> <img width="50%" alt="image" src="https://github.com/dami0806/SpartaAssignment/assets/85047035/41458b88-5c9f-4c16-b4f9-4f4a5aec167a"> <img width="50%" alt="image" src="https://github.com/dami0806/SpartaAssignment/assets/85047035/6372f894-0963-4a04-b772-81d21e1030c0"> | | 과목 선택 후<br> 점수를 등록하는 화면과<br> 추가 입력 문구가 보이는 화면 |
| 점수 나갔다가 들어와서 이어서 등록    | <img width="50%" alt="image" src="https://github.com/dami0806/SpartaAssignment/assets/85047035/67911319-373e-467b-b758-ba654d03605b"> <img width="40%" alt="image" src="https://github.com/dami0806/SpartaAssignment/assets/85047035/2aa07642-106b-41c0-935d-259c94dabb20">| 과목 선택 후 점수를<br> 등록하는 화면과 <br>추가 입력이 필요한<br> 문구가 보이는 화면 |
| 점수 등급 조회          | <img width="50%" alt="image" src="https://github.com/dami0806/SpartaAssignment/assets/85047035/7fd9c3e3-7a97-4b24-8c47-c66c34b994d6"> <img width="50%" alt="image" src="https://github.com/dami0806/SpartaAssignment/assets/85047035/77a69776-0f96-4d76-90c1-77849a663acc"> | 필수과목과 선택과목 점수 등급을 조회 |
| 점수 수정               | <img width="40%" alt="image" src="https://github.com/dami0806/SpartaAssignment/assets/85047035/5bd43bea-83b6-4182-aec1-01b385b9cee2"> | 수강생의 과목별 회차 점수를 수정하는 화면 |
| 수정된 필수과목 등급 확인(95점) | <img width="50%" alt="image" src="https://github.com/dami0806/SpartaAssignment/assets/85047035/a2d70f18-69f6-4df8-a664-83cbdfdf3996"> | 수정 후 필수과목 점수 95점을 확인하는 화면 |
|프로그램 종료 | <img width="60%" alt="image" src="https://github.com/dami0806/SpartaAssignment/assets/85047035/aaebdec7-a250-46c5-857e-bcd3908218d6">| 작업이 끝난후 프로그램을 종료 |

 ---
  
# 사용된 기술 개념

## 계산기  

### [1. Level 1](https://github.com/dami0806/Sparta_Assignment/wiki#level-1)
 - [Static](https://github.com/dami0806/Sparta_Assignment/wiki#static)

### [2. Level 2](https://github.com/dami0806/Sparta_Assignment/wiki#level-2)
- [접근제한자 private 사용](https://github.com/dami0806/Sparta_Assignment/wiki#%EC%A0%91%EA%B7%BC%EC%A0%9C%ED%95%9C%EC%9E%90-private-%EC%82%AC%EC%9A%A9)

### [3. Level 3](https://github.com/dami0806/Sparta_Assignment/wiki#level-3)
- [1. Enum](https://github.com/dami0806/Sparta_Assignment/wiki#1-enum)
- [2. 제네릭스와 BiFunction](https://github.com/dami0806/Sparta_Assignment/wiki#2-%EC%A0%9C%EB%84%A4%EB%A6%AD%EC%8A%A4%EC%99%80-bifunction-%EC%9D%B8%ED%84%B0%ED%8E%98%EC%9D%B4%EC%8A%A4)
- [3. 람다와 스트림](https://github.com/dami0806/Sparta_Assignment/wiki#3-%EB%9E%8C%EB%8B%A4%EC%99%80-%EC%8A%A4%ED%8A%B8%EB%A6%BC)

  - [3-1. 멀티스레딩 환경에서의 람다 표현식의 안전성](https://github.com/dami0806/Sparta_Assignment/wiki#%EC%82%AC%EC%9A%A9-%EC%83%81%ED%99%A9-%EC%A0%95%EB%A6%AC)

  - [3-2. static VS 람다](https://github.com/dami0806/Sparta_Assignment/wiki#static-vs-%EB%9E%8C%EB%8B%A4)

    - [3-2.1 차이 비교 정리](https://github.com/dami0806/Sparta_Assignment/wiki#%EC%B0%A8%EC%9D%B4-%EB%B9%84%EA%B5%90-%EC%A0%95%EB%A6%AC)

    - [3-2.2 사용 상황 정리](https://github.com/dami0806/Sparta_Assignment/wiki#%EC%82%AC%EC%9A%A9-%EC%83%81%ED%99%A9-%EC%A0%95%EB%A6%AC)


# [피드백](https://github.com/dami0806/SpartaAssignment/wiki#%ED%94%BC%EB%93%9C%EB%B0%B1)

- [1. camelCase VS snake_case](https://github.com/dami0806/SpartaAssignment/wiki#1-camelcase-vs-snake_case)

  - [java는 일반적으로 camelCase 스타일을 사용해서 클래스명, 메서드명, 변수명을 짓는다.](https://github.com/dami0806/SpartaAssignment/wiki#java%EB%8A%94-%EC%9D%BC%EB%B0%98%EC%A0%81%EC%9C%BC%EB%A1%9C-camelcase-%EC%8A%A4%ED%83%80%EC%9D%BC%EC%9D%84-%EC%82%AC%EC%9A%A9%ED%95%B4%EC%84%9C-%ED%81%B4%EB%9E%98%EC%8A%A4%EB%AA%85-%EB%A9%94%EC%84%9C%EB%93%9C%EB%AA%85-%EB%B3%80%EC%88%98%EB%AA%85%EC%9D%84-%EC%A7%93%EB%8A%94%EB%8B%A4)
    
- [2. 문자열 비교 equal 와 NullPointerException](https://github.com/dami0806/SpartaAssignment/wiki#2-%EB%AC%B8%EC%9E%90%EC%97%B4-%EB%B9%84%EA%B5%90-equal-%EC%99%80-nullpointerexception)
  
  - [NPE 방지하고 equal 사용방법](https://github.com/dami0806/SpartaAssignment/wiki#npe-%EB%B0%A9%EC%A7%80%ED%95%98%EA%B3%A0-equal-%EC%82%AC%EC%9A%A9%EB%B0%A9%EB%B2%95)
----

## 2. Student ManageMent System.



