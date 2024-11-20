># 단계별 계산기 만들기



>### Level 1 계산기 | 단일 클래스
- 피연산자2, 연산자1 입력받기

- Switch문으로 연산

---

>### Level 2 계산기 | 클래스 분할

---

<details>
<summary>App Class</summary>
<br>

**메뉴 실행**

연산, 연산결과 내역 출력, 내역 삭제

</details>

---

<details>
<summary>Calculator Clasee</summary>
<br>

**메서드**

calculate() : 연산 실행, 결과 ArrayList에 저장

getResultArray() : ArrayList 출력

setResultArray() : ArrayList에서 가장 오래된 내역 삭제



</details>



---

>### Level 3 계산기 | 클래스 분할

---

<details><summary>패키지 구조화</summary>

```bash
src
│   ├── main
│   │   └── Main.java
│   ├── calculator
│   │   ├── Calculator.java
│   │   └── InputValue.java
│   ├── core
│   │   ├── ArithmeticCalculator.java
│   │   ├── ComparedResultPrinter  
│   │   ├── CallbackResult.java  (Interface)
│   │   └── ArithmeticDataBridge.java  (Interface)
│   ├── operation
│   │   ├── Operator.java (Interface)
│   │   ├── AddOperator.java
│   │   ├── SubtractOperator.java
│   │   ├── MultiplyOperator.java
│   │   ├── DivideOperator.java
│   │   └── OperatorType.java
```
</details>

---

<details><summary>Main 클래스</summary>
<br>

<u>**계산기를 실행**</u>

-- Calculator와 연결

-- Calculator.run() 실행

</details>

---

<details><summary>Calculator 클래스</summary>
<br>

<u>**메뉴 선택 분기점**</u>

계산:  ArithmeticCalculator.startCalculate();

결과 비교 출력:   comparedResultPrinter.printResult();

종료:  return

1. startCalculate()호출

2. ArithmeticCalculator 연산 종료, 연산 결과 result 리턴
3. CallbackResult 인스턴스를 통해 Calculator로 result 전달
4. 전달받은 결과값을 ArrayList에 저장

<u>*by CallbackResult , Calculator는 연산 종료 시점을 모름</u>

</details>

---

<details><summary>ArithmeticCalculator 클래스</summary>
<br>

<u>**연산 수행**</u>
1. startCalculate() 호출받으면 inputValue.getUserInput() 호출

2. via ArithmeticDataBridge인스턴스의 메서드,<br>InputValue의 값을 제네릭으로 전달받음
3. setValues메서드 내에서 제네릭으로 전달받은 값이 Number타입이 아니면 예외 발생시키기<br>
   Number타입이 맞다면, calculate() 실행 <Br>
   calculate()에서 Operator 인터페이스 객체 생성<br>
   switch로 이넘 연산자타입 비교 후<br>
   연산자 타입에 맞는 연산객체 초기화
   연산 결과 리턴<br>
   리턴받은 값을 reulst에 저장<br>
   via callbackResult의 메서드, result 값 Calculator로 전달

</details>

---

<details><summary>ComparedResultPrinter 클래스</summary>
<br>

<u>**입력받은 값 보다 더 큰 연산 결과값들 출력하기**</u>

1. Calculator의 List컬랙션 results 전달받기

2. 입력받은 값 number변수에 초기화
3. results 리스트를 스트림화 한 컬렉션 biggerNumber 초기화
4. biggerNumber을 순회하면서 number보다 큰 값만 남김
5. 필터링된 결과를 새로운 리스트로 변환하여 biggerNumber에 할당


</details>

---

<details><summary>InputValue</summary>
<br>

**<u>**값 입력받고 전달하기**</u>**


</details>


---
