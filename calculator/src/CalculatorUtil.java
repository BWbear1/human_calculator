public class CalculatorUtil {

    private final static String OPERATOR_ENTERED_INCORRECTLY_ERROR = "Т.к не коректно введен оператор в уравнении";
    private final static String INCORRECT_DATA_ENTERED_ERROR = "т.к введены некорректные данные, допустимый диапазон значений [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10][I, II, III, IV, V, VI, VII, VIII, IX, X]";

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
