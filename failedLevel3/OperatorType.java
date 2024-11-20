package failedLevel3;

public enum OperatorType {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    private final char sign;

    OperatorType(char sign){
        this.sign = sign;
    }

    public char getSign(){
        return sign;
    }

    public static OperatorType toEnum(char operator){
        for(OperatorType type : OperatorType.values()) {
            if (type.sign == operator) {
                return type;
            }
        }throw new IllegalArgumentException("유효하지 않은 연산자: " + operator );
    }
}
