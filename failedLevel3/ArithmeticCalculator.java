package failedLevel3;

public class ArithmeticCalculator {

    public int calculate(InputValue inputvalue){
        Operator operator;

        switch(inputvalue.getOperation()){
            case ADD -> operator = new AddOperator();
            case SUBTRACT -> operator = new SubtractOperator();
            case MULTIPLY -> operator = new MultiplyOperator();
            case DIVIDE -> operator = new DivideOperator();
            default -> throw new IllegalArgumentException("잘못된 연산자입니다: " + inputvalue.getOperation());
        }return operator.operate(inputvalue.getOperand1(), inputvalue.getOperand2());
    }
}
