import java.util.Scanner;

public class Main {
    public static String ERROR1 = "т.к. введенная строка не является математической операцией";

    public static void main(String[] args) {
        CalculatorService calc = new CalculatorService();
        String result = calc.init();
        System.out.println("Результат:" + result);


    }
}


