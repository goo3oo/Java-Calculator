package level3Calculator.operation;

public enum OperatorType {
    // 연산자 기호들을 상수 객체로 선언
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    private final char sign; // 연산자를 나타내는 문자, 객체의 속성

    OperatorType(char sign) {
        this.sign = sign; // enum = 생성자 자동 호출 -> 각각의 연산자 기호를 sign 변수에 할당
    }

    public char getSign() {
        return sign;    // ArithmeticCalculator 객체의 '연산결과 & 식 출력'에서 기호 필요
    }

    //char 로 입력받은 operator 를 OperatorType 으로 변경
    public static OperatorType toEnum(char operator) {
        for (OperatorType type : OperatorType.values()) {  // OperatorType 들을 순회,
            if (type.sign == operator) {                   // 입력받은 연산자와 enum 의 기호가 일치하는지 확인
                return type;                               // 일치하면 OperatorType 객체를 반환
            }
        }
        throw new IllegalArgumentException("유효하지 않은 연산자:" + operator); //유효하지 않은 연산자가 들어오면 예외 발생
    }
}

