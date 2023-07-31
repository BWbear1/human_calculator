public class RomanConvertToArabic {
    private final String INCORRECT_DATA_ENTERED_ERROR = "т.к введены некорректные данные, допустимый диапазон значений [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10][I, II, III, IV, V, VI, VII, VIII, IX, X]";
    int[] ARABIC_NUMERALS = {100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] ROMAN_NUMERALS = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public int convertRomanToArabicNumbers(String line1) { // перевод римлян в арабов
        int number1 = 0;
        for (int i = 0; i < ARABIC_NUMERALS.length; i++) {
            while (line1.indexOf(ROMAN_NUMERALS[i]) == 0) {
                number1 += ARABIC_NUMERALS[i];
                line1 = line1.substring(ROMAN_NUMERALS[i].length());
            }
        }
        if (line1 == null || line1.isEmpty() || line1.trim().isEmpty()) {
            return number1;
        } else {
            throw new RuntimeException(INCORRECT_DATA_ENTERED_ERROR);
        }
    }
}//перевод римлян в арабов для вычислений
