package level3Calculator.calculator;
import level3Calculator.core.ArithmeticCalculator;
import level3Calculator.core.CallbackResult;
import level3Calculator.core.ComparedResultPrinter;

import java.util.*;


public class Calculator implements CallbackResult {

    private final List<Double> results = new ArrayList<>(); // CallbackResult 인터페이스에서 받은 result 값을 저장할 리스트

    private final ArithmeticCalculator<Double> arithmeticCalculator; // ArithmeticCalculator 객체 주입받기
    private final  ComparedResultPrinter comparedResultPrinter; // comparedResultPrinter 객체 주입받기

    public Calculator(){
        arithmeticCalculator = new ArithmeticCalculator<>(this);// CallbackResult 를 전달빋는 ArithmeticCalculator 객체 생성
        comparedResultPrinter = new ComparedResultPrinter(this.results); //멤버변수 results 를 전달받는 ComparedResultPrinter 객체 생성
    }

    // 인스턴스 CallbackResult 구현

    @Override
    public void onCompleteResult(double result){
        results.add(result);
    }   // 연산 결과를 list 에 추가

    //1번~3번 분기처리
    public void run(){
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("1:계산, 2: 결과 비교 출력 3: 종료");
            int select;

            try{
                select = scan.nextInt();
            }catch(InputMismatchException e){
                System.out.println("유효한 번호가 아닙니다. 다시 입력해주세요.");
                scan.nextLine();
                continue;
            }
            switch (select) {
                case 1 : arithmeticCalculator.startCalculate();
                    break;
                case 2 : comparedResultPrinter.printResult();
                    break;
                case 3 : System.out.println("종료합니다.");
                    return;
            }
        }
    }
 }


