public class ArabicNumberValidationService2 {
    String ERROR6 = "т.к введены некорректные данные, допустимый диапазон значений [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10][I, II, III, IV, V, VI, VII, VIII, IX, X]";

    boolean arabicNumberIsCorrect2(String line1) {
        int number1;
        try {
            number1 = Integer.parseInt(line1);
            String[] massiv = line1.split("");
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}// проверка на интовость
