public class CalculatorUtil {

    private final static String OPERATOR_ENTERED_INCORRECTLY_ERROR = "Т.к не коректно введен оператор в уравнении";

    public int selectOperatorAndCalculate(String operator, int number1, int number2) {
        switch (operator) {
            case "+":
            {
                return number1 + number2;
            }
            case "-":{
                return number1 - number2;
                }
            case "*":{
                return number1 * number2;
                }
            case "/": {
                return number1 / number2;
            }
            default:
                throw new IllegalArgumentException(OPERATOR_ENTERED_INCORRECTLY_ERROR);
        }
    }
}
