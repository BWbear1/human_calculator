public class ArabicNumberValidationService {
    private final static String INCORRECT_DATA_ENTERED_ERROR = "т.к введены некорректные данные, допустимый диапазон значений [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10][I, II, III, IV, V, VI, VII, VIII, IX, X]";

    public boolean arabicNumberIsCorrect(String number1) {
        int numberForCheck;
        try {
            numberForCheck = Integer.parseInt(number1);
            String[] massiv = number1.split("");
            if (massiv[0].equals("0") || numberForCheck > 10 || numberForCheck < 1) {
                throw new ArithmeticException(INCORRECT_DATA_ENTERED_ERROR);
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean arabicNumberIsCorrectForFulfillTheTaskConditionsForDifferentNumberSystemsScyko(String number1) {
        int numberForCheck;
        try {
            numberForCheck = Integer.parseInt(number1);
            //String[] massiv = number1.split("");
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}// проверка на интовость

