package level3Calculator.core;

import java.util.List;

public interface CallbackResult {
    //Calculator 클래스가 구현
    void onCompleteResult(double result);

    List<Double> getResult();
}
