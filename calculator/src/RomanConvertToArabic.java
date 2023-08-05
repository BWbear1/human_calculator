public class RomanConvertToArabic {
    private final static String INCORRECT_DATA_ENTERED_ERROR = "т.к введены некорректные данные, допустимый диапазон значений [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10][I, II, III, IV, V, VI, VII, VIII, IX, X]";
    private static int[] ARABIC_NUMERALS = {100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static String[] ROMAN_NUMERALS = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public int convertRomanToArabicNumbers(String number1) { // перевод римлян в арабов
        int numberConversionResult= 0;
        for (int i = 0; i < ARABIC_NUMERALS.length; i++) {
            while (number1.indexOf(ROMAN_NUMERALS[i]) == 0) {
                numberConversionResult+= ARABIC_NUMERALS[i];
                number1 = number1.substring(ROMAN_NUMERALS[i].length());
            }
        }
        if (number1 == null || number1.isEmpty() || number1.trim().isEmpty()) {
            return numberConversionResult;
        } else {
            throw new RuntimeException(INCORRECT_DATA_ENTERED_ERROR);
        }
    }
}//перевод римлян в арабов для вычислений
