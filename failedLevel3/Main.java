package failedLevel3;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();
        OutputValue outputValue = new OutputValue();

        Menu menu = new Menu(scan, arithmeticCalculator, outputValue);

        menu.run();
    }
}
