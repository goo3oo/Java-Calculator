package level3Calculator.calculator;

import level3Calculator.core.ArithmeticDataBridge;
import level3Calculator.operation.OperatorType;

import java.util.Scanner;

public class InputValue<T> {

    private final ArithmeticDataBridge<T> dataBridge;
    private final Scanner scan;

    public InputValue(ArithmeticDataBridge<T> dataBridge) {
        this.dataBridge = dataBridge;       // dateBrigde를 통해 ArithmeticCalculator에 접근하기 위해
        this.scan = new Scanner(System.in);
    }

    public void getUserInput() {

        System.out.print("첫 번쨰 숫자를 입력하세요: ");
        T operand1 = parseInput();

        System.out.print("두 번째 숫자를 입력하세요: ");
        T operand2 = parseInput();

        char operator = getOperate();

        OperatorType operatorType = OperatorType.toEnum(operator); // operator를 toEnum메서드를 통해서 enum으로 변환

        dataBridge.setValues(operand1, operand2, operatorType); // ArithmeticCalculator 로 값 보내기
    }

    private T parseInput() {

        while (true) {
            String input = scan.next();
            try {
                if (input.contains(".")) {
                    // 소수점이 있는 경우 Double 로 변환
                    return (T) Double.valueOf(input);
                } else {
                    // 소수점이 없는 경우 Integer 로 변환
                    return (T) Integer.valueOf(input);
                }
            } catch (NumberFormatException e) {
                // 잘못된 숫자 형식이 들어왔을 경우 예외 처리
                System.out.println("유효하지 않은 숫자: " + input + ". 다시 입력해주세요.");
            }
        }
    }

    public char getOperate() {
        while (true) {
            System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /): ");
            String input = scan.next();

            if (input.length() == 1 && "+-*/".contains(input)) {
                return input.charAt(0); //문자열 "+-*/"에 input이 포함되어 있으면 문자열 input 의 첫번재 문자 출력
            } else {
                System.out.println("유효하지 않은 연산자: " + input + ". 다시 입력해주세요.");
            }
        }
    }
}

