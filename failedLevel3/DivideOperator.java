package failedLevel3;

public class DivideOperator extends Operator{
    @Override
    public int operate(int operand1, int operand2) {
        if(operand2==0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return operand1 /  operand2;
    }
}
