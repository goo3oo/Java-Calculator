package level3Calculator.core;

import level3Calculator.calculator.InputValue;
import level3Calculator.operation.*;

public class ArithmeticCalculator<T> implements ArithmeticDataBridge<T> {

    private final CallbackResult callbackResult;
    private final InputValue<T> inputValue;


    public ArithmeticCalculator(CallbackResult callbackResult) {
        this.callbackResult = callbackResult; // Calculator 객체에서 전달받은 callbackResult 멤버변수에 저장
        this.inputValue = new InputValue<>(this); // ArithmeticDataBridge 를 전달받는 InputValue 객체 생성
    }

    //ArithmeticDataBridge 인스턴스 구현
    //setValues 메서드로 사용자로부터 입력받은 InputValue 객체의 operand1, operand2, operator 전달받음
    @Override
    public void setValues(T operand1, T operand2, OperatorType operator) {
        if (operand1 instanceof Number && operand2 instanceof Number) {
            double op1 = ((Number) operand1).doubleValue(); // T로 전달받은 operand1 -> double 로 변환
            double op2 = ((Number) operand2).doubleValue(); // T로 전달받은 operand2 -> double 로 변환
            double result = calculate(op1, op2, operator); // 더블 op1, op2으로 변환한 값 & operator -> calculate()(연산실행)

            callbackResult.onCompleteResult(result); // CallbackResult 통해 Calculator 객체로 result 값 전달

            System.out.println(op1 + " " + operator.getSign() + " " + op2 + " = " + result); // 연산결과 & 식 출력
        } else {
            throw new ArithmeticException("숫자를 입력해주세요."); // T로 넘겨받은 operand1과 operand2가 Number 가 아닐 경우 예외처리
        }                                                      // 제네릭을 어떻게 잘 써야할지 모르겠어서 이렇게 시도....
    }

    public void startCalculate() {
        inputValue.getUserInput(); // 주입받은 inputValue 객체의 getUserInput() 실행 , 사용자로부터 값을 입력받는 메서드
    }

    public double calculate(double operand1, double operand2, OperatorType operator) {
        Operator operatorInstance; // Operator 인스턴스의 변수 operatorInstance 선언

        switch (operator) {        // 전달받은 enum 타입의 operator 와 일치하는 연산객체로 초기화
            case ADD -> operatorInstance = new AddOperator();
            case SUBTRACT -> operatorInstance = new SubtractOperator();
            case MULTIPLY -> operatorInstance = new MultiplyOperator();
            case DIVIDE -> operatorInstance = new DivideOperator();
            default -> throw new IllegalArgumentException("잘못된 연산자입니다: " + operator); // 다른 연산자 입력되면 예외처리
        }
        return operatorInstance.operate(operand1, operand2); // 초기화된 연산객체의 함수로 operand1, operand2 매개변수로 전달
    }
}

