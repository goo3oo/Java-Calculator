package level3Calculator.operation;

public class SubtractOperator extends Operator {
    // 연산자기 SUBTRACT -> 해당 객체
    @Override
    public double operate(double operand1, double operand2) {
        return operand1 - operand2;
    }
}
