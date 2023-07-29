class Calculation {
    public static String ERROR5 = "Т.к не коректно введен оператор в уравнении";

    //считалочка
    int calculation(String operator, int number1, int number2) {
        int ITOG;
        switch (operator) {
            case "+":
                ITOG = number1 + number2;
                break;
            case "-":
                ITOG = number1 - number2;
                break;
            case "*":
                ITOG = number1 * number2;
                break;
            case "/": {
                ITOG = number1 / number2;
            }
            break;
            default:
                throw new IllegalArgumentException(ERROR5);
        }
        return ITOG;
    }
}
