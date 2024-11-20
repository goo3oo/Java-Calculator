package level2Calculator;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Calculator calculator = new Calculator();
        while (true) {
            System.out.println("1:계산기, 2: 내역 확인, 3: 내역 삭제 4: 종료");
            int menu = sc.nextInt();
            switch(menu){
                case 1: System.out.print("첫 번쨰 숫자를 입력하세요: ");
                        int num1 = sc.nextInt();

                        System.out.print("두 번째 숫자를 입력하세요: ");
                        int num2 = sc.nextInt();
                        sc.nextLine();

                        System.out.print("사칙연산 기호를 입력하세요: ");
                        char operator = sc.next().charAt(0);
                        sc.nextLine();
                        calculator.calculate(num1, num2, operator);
                        break;
                case 2: calculator.getResultArray();
                        break;
                case 3: calculator.setResultArray();
                        break;
                case 4: System.out.println("종료합니다.");
                        return;
                default:
                    System.out.println("돌아가");
                }
            }
        }
    }
