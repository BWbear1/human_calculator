import java.util.Scanner;

public class CalculatorService {
    private final String NOT_A_MATHEMATICAL_OPERATION_ERROR = "т.к. введенная строка не является математической операцией";

    public String init() {
        System.out.println("Введите уравнение:");
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        if (input.length < 3 || input.length > 4) {
            throw new RuntimeException(NOT_A_MATHEMATICAL_OPERATION_ERROR);
        }

        String line1 = input[0];
        String operator = input[1];
        String line2 = input[2];

        ValidationNumbers numbersCheck = new ValidationNumbers();
        numbersCheck.validationNumbers(line1, line2);
        CalculationStart result = new CalculationStart();

        return result.calculationStart(line1, operator, line2);
    }
}


