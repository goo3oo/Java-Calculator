package level2Calculator;

import java.util.ArrayList;

public class Calculator {
    private final ArrayList<Integer> resultArray = new ArrayList<Integer>();

    public void calculate(int num1, int num2, char operator) {

        Integer result = null;

        switch(operator){
            case '+' -> result = num1 + num2;
            case '-' -> result = num1 - num2;
            case '*' -> result = num1 * num2;
            case '/' -> {
                if (num2==0){
                    System.out.println("0으로 나눌 수 없습니다.");
                }else{
                    result = num1 / num2;
                }
            }default -> System.out.println("잘못된 연산자를 입력하셨습니다.");
        }
        if (result != null) {//null 안 쓸거면 예외처리를 해야함.
            resultArray.add(result);
            System.out.println("결과: " + result);
        }
    }

    public void getResultArray(){
        for (Integer result : resultArray) {
            System.out.print("["+result+"]");
        }   System.out.println();
    }

    public void setResultArray() {
        if (resultArray.isEmpty()) {
            System.out.println("돌아가");
        } else {
            System.out.println("가장 오래된 내역부터 삭제합니다.");
            resultArray.remove(0);
        }
    }
}
