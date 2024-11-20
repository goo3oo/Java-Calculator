package level1Calculator;
import java.util.Scanner;
import java.util.InputMismatchException;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        do {
            int operand1 = 0;
            int operand2 = 0;
            boolean validTest = false;

            while(!validTest){
                System.out.print("첫 번째 숫자를 입력하세요: ");
                try{
                    operand1 = scan.nextInt();
                    validTest = true;
                }catch (InputMismatchException e){
                    System.out.println("숫자를 입력해주세요.");
                    scan.nextLine();
                }
            }
            validTest = false;

            while(!validTest){
                System.out.print("두 번째 숫자를 입력하세요: ");
                try{
                    operand2 = scan.nextInt();
                    validTest = true;
                }catch (InputMismatchException e){
                    System.out.println("숫자를 입력해주세요.");
                    scan.nextLine();
                }
            }
            scan.nextLine();

            System.out.println("(사칙연산 기호) + - * / ^ ");
            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = scan.nextLine().charAt(0);

            int result ;
            double dResult ;
            if (operand2 == 0 && operator == '/') {
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다");
                return;
            }

            switch (operator) {
                case '+':
                    result = operand1 + operand2;
                    System.out.println("결과: " + operand1 + " + " + operand2 + " = " + result);
                    break;
                case '-':
                    result = operand1 - operand2;
                    System.out.println("결과: " + operand1 + " - " + operand2 + " = " + result);
                    break;
                case '*':
                    result = operand1 * operand2;
                    System.out.println("결과: " + operand1 + " * " + operand2 + " = " + result);
                    break;
                case '/':
                    dResult = (double) operand1 / operand2;
                    System.out.println("결과: " + operand1 + " / " + operand2 + " = " + dResult);
                    break;
                case '^':
                    dResult = Math.pow(operand1,operand2);
                    System.out.println("결과:" + operand1+ " ^ " + operand2 + " = " + dResult );
                default:
                    System.out.println("잘못된 연산자를 입력하셨습니다.");
                    break;
            }
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
        } while (!scan.nextLine().equals("exit"));
    }
}
