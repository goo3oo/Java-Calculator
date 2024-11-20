package level3Calculator.operation;

public class DivideOperator extends Operator {
    // 연산자 DIVIDE -> 해당 객체 
    @Override
    public double operate(double operand1, double operand2) {
        if(operand2==0){
            throw(new ArithmeticException("0으로 나눌 수 없습니다.")); // 분모가 0이되면 ArithmeticException 로 예외 처리
        }
        return operand1 /  operand2;
    }
}
