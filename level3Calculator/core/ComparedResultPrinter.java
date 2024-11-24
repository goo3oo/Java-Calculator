package level3Calculator.core;

import java.util.*;

public class ComparedResultPrinter {

//    private final List<Double> results;
    private final CallbackResult callbackResult;

    public ComparedResultPrinter(CallbackResult callbackResult) {
//        this.results = results;
        this.callbackResult = callbackResult;
    }

    public void printResult() {
        List<Double> results = callbackResult.getResult();

        Scanner scan = new Scanner(System.in);

        System.out.println("비교할 값을 입력해주세요.");
        double number;

        while (true) {
            String input = scan.nextLine();
            if (isValidNumber(input)) {
                number = Double.parseDouble(input);

                List<Double> biggerNumber = results.stream()
                        .filter(num -> num > number)
                        .toList();

                if (biggerNumber.isEmpty()) {
                    System.out.println("입력한 값보다 큰 계산 결과가 없습니다.");
                } else {
                    System.out.println("입력한 값보다 큰 결과들: " + biggerNumber);
                }

                break;
            } else {
                System.out.println("숫자를 입력해주세요.");
            }
        }
    }


    public boolean isValidNumber(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
