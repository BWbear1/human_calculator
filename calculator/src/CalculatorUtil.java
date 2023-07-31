public class CalculatorUtil {

    private final String OPERATOR_ENTERED_INCORRECTLY_ERROR = "Т.к не коректно введен оператор в уравнении";

    public int calculation(String operator, int number1, int number2) {
        int result;
        switch (operator) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/": {
                result = number1 / number2;
            }
            break;
            default:
                throw new IllegalArgumentException(OPERATOR_ENTERED_INCORRECTLY_ERROR);
        }
        return result;
    }
}
