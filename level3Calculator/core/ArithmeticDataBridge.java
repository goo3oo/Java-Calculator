package level3Calculator.core;

import level3Calculator.operation.OperatorType;

public interface ArithmeticDataBridge<T> {
   //ArithmeticCalculator 클래스가 구현
    void setValues(T operand1, T operand2, OperatorType operator);
}
