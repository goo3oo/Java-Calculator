package failedLevel3;
import java.util.Scanner;

public class Menu {

    private final Scanner scan;
    private final ArithmeticCalculator arithmeticCalculator;
    private final OutputValue outputValue;

    public Menu(Scanner scan, ArithmeticCalculator arithmeticCalculator, OutputValue outputValue) {
        this.scan = scan;
        this.arithmeticCalculator = arithmeticCalculator;
        this.outputValue = outputValue;
    }

    public void run() {
        while (true) {
            System.out.println("1:계산기, 2: 내역 확인, 3: 내역 삭제 4: 종료");
            int select = scan.nextInt();
            switch (select) {
                case 1 : calculate();
                         break;
                case 2 : System.out.println();
                         break;
                case 3 : System.out.println(123);
                         break;
                case 4 : System.out.println("종료합니다.");
                         return;
            }
        }
    }
    public void calculate(){
        System.out.print("첫 번쨰 숫자를 입력하세요: ");
        int operand1 = scan.nextInt();

        System.out.print("두 번째 숫자를 입력하세요: ");
        int operand2 = scan.nextInt();
        scan.nextLine();

        System.out.print("사칙연산 기호를 입력하세요: ");
        char operator = scan.next().charAt(0);

        InputValue inputValue = new InputValue(operand1, operand2, OperatorType.toEnum(operator));
        int result = arithmeticCalculator.calculate(inputValue);
        outputValue.printResult(result);
    }

}
