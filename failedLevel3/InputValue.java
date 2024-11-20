package failedLevel3;

public class InputValue{
    private final int operand1;
    private final int operand2;
    private final OperatorType operatorType;

    public InputValue(int operand1, int operand2, OperatorType operatorType){
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operatorType = operatorType;
    }

    public int getOperand1(){
        return operand1;
    }

    public int getOperand2(){
        return operand2;
    }

    public OperatorType getOperation(){
        return operatorType;
    }
}
