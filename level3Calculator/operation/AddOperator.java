package level3Calculator.operation;

public class AddOperator extends Operator {
    // 연산자 ADD -> 해당 객체
    @Override
    public double operate(double operand1, double operand2) {
        return operand1+ operand2;
    }
}
