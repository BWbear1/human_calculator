public class ArabicNumberValidationService {
    private final String INCORRECT_DATA_ENTERED = "т.к введены некорректные данные, допустимый диапазон значений [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10][I, II, III, IV, V, VI, VII, VIII, IX, X]";

    public boolean arabicNumberIsCorrect(String line1) {
        int number1;
        try {
            number1 = Integer.parseInt(line1);
            String[] massiv = line1.split("");
            if (massiv[0].equals("0") || number1 > 10 || number1 < 1) {
                throw new ArithmeticException(INCORRECT_DATA_ENTERED);
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}// проверка на интовость

