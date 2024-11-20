# 계산기 만들기➕➖✖️➗

## 프로젝트 소개
계산기를 단계적으로 설계하면서 객체 지향 프로그래밍(OOP) 개념을 학습하고,   
클래스 분할, 컬렉션, 제네릭, 스트림, Enum을 활용하여 학습하기 위한 프로젝트


## 목차🔗
1. [Level 1 - 단일 클래스 계산기](#level-1---단일-클래스-계산기)
2. [Level 2 - 클래스 분할](#level-2---클래스-분할)
3. [Level 3 - Java의 기능 활용](#level-3---java의-기능-활용)
4. [클래스 및 역할 설명](#클래스-및-역할-설명)
5. [구현 상세](#구현-상세)
6. [배운 점 및 개선점](#배운-점-및-개선점)


## Level 1 - 단일 클래스 계산기
- **기능**: 피연산자 2개와 연산자 1개를 입력받아 계산 결과를 출력
- **구현 방식**: switch문을 사용해 연산을 수행

## Level 2 - 클래스 분할
<ul>
<li>기능 확장</li>
<ul>
<li>연산 실행</li>
<li>연산 결과 내역 저장 및 출력</li>
<li>내역 삭제</li>
</ul>
<li>구현 방식</li>
<ul>
<li>클래스 분리(App와 Calculator) </li>
<li>결과를 저장하기 위해 ArrayList 사용 </li>
</ul>
<li>추가된 주요 메서드</li>
<ul>
<li>calculate(): 연산 실행 및 결과 저장 </li>
<li>getResultArray(): 결과 내역 출력 </li>
<li>setResultArray(): 가장 오래된 내역 삭제 </li>
</ul>
</ul>


## Level 3 - Java의 기능 활용
<ul>
<li>기능 확장: 컬렉션, 제네릭, 스트림, Enum 활용
<li>패키지 구성:
</ul>

```bash

src
├── main
│   └── Main.java
├── calculator
│   ├── Calculator.java
│   └── InputValue.java
├── core
│   ├── ArithmeticCalculator.java
│   ├── ComparedResultPrinter.java
│   ├── CallbackResult.java  (Interface)
│   └── ArithmeticDataBridge.java  (Interface)
├── operation
│   ├── Operator.java (Interface)
│   ├── AddOperator.java
│   ├── SubtractOperator.java
│   ├── MultiplyOperator.java
│   ├── DivideOperator.java
│   └── OperatorType.java
```

## 클래스 및 역할 설명
#### Main
<ul>
<li>계산기 프로그램의 진입점.
<li>메뉴 실행(Calculator.run() 호출).
</ul>

#### Calculator
<ul>
<li>사용자 입력을 받아 메뉴를 선택하고 실행.
<li>연산 결과를 관리(ArrayList 사용).
<li>ArithmeticCalculator와 ComparedResultPrinter 클래스와 상호작용.
</ul>

#### ArithmeticCalculator


* 입력값을 받아 연산을 수행.
* 연산 결과를 CallbackResult 인터페이스를 통해 전달.
* 주요 기능:
    + 입력값의 타입을 판별(Integer, Double).
    + 연산자에 따라 적합한 연산 클래스(AddOperator, DivideOperator 등)를 생성하여 계산 수행.


#### ComparedResultPrinter
<ul>
<li>입력값보다 큰 연산 결과만 필터링하여 출력.
</ul>

#### InputValue
<ul>
<li>사용자 입력값을 받아 제네릭 타입으로 변환 후 전달.
</ul>

#### Operation 패키지
<ul>
<li>각 연산자별 연산 클래스를 정의.
</ul>


## 구현 상세
<ul>
<li>제네릭 활용
<ul>
<li>InputValue 클래스에서 입력값의 타입(Integer, Double)을 판별하여 처리.
</ul>
<li>콜백 방식
<ul>
<li>연산 결과를 CallbackResult를 통해 전달하여 종속성을 줄임.
</ul>
<li>스트림 활용
<ul>
<li>결과 비교 시 필터링 및 리스트 변환 작업에 Stream 사용.
</ul>
</ul>


## 배운 점 및 개선점
1. **배운 점:**
<ul>
<li>클래스 간 결합도를 줄이기 위해 인터페이스와 콜백을 활용하는 방법.
<li>스트림을 사용하는 법.
<li>구조를 짜기 전에 어떤 기능을 구현할지 명확히 해야 할 필요성.
</ul>

2. **개선점:**
<ul>
<li>입력값 타입에 따라 결과 출력 타입도 달라지도록 개선 필요.
<li>리드미 작성과 트러블슈팅 기록에 더 많은 시간 투자.
<li>제네릭의 의의에 맞는 사용.
</ul>
