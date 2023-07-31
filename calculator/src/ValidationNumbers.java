public class ValidationNumbers {
    RomanNumberValidationService validationRoman = new RomanNumberValidationService();
    ArabicNumberValidationService validationArabic = new ArabicNumberValidationService();
    ArabicNumberValidationService validationArabic2 = new ArabicNumberValidationService();
    private final String INCORRECT_DATA_ENTERED_ERROR = "т.к введены некорректные данные, допустимый диапазон значений [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10][I, II, III, IV, V, VI, VII, VIII, IX, X]";
    private final String DIFFERENT_NUMBER_SYSTEMS_ERROR = "т.к используются одновременно разные системы счисления";

    public void validationNumbers(String firstNumber, String secondNumber) {
        boolean firstRomanNumberIsCorrect = validationRoman.isRomeNumberCorrect(firstNumber);
        boolean secondRomanNumberIsCorrect = validationRoman.isRomeNumberCorrect(secondNumber);
        boolean firstArabicNumberIsCorrect2 = validationArabic2.arabicNumberIsCorrect2(firstNumber);
        boolean secondArabicNumberIsCorrect2 = validationArabic2.arabicNumberIsCorrect2(secondNumber);

        if ((firstRomanNumberIsCorrect && !firstArabicNumberIsCorrect2 && !secondRomanNumberIsCorrect && secondArabicNumberIsCorrect2) || (!firstRomanNumberIsCorrect &&
                firstArabicNumberIsCorrect2 && secondRomanNumberIsCorrect && !secondArabicNumberIsCorrect2)) {
            throw new ArithmeticException(DIFFERENT_NUMBER_SYSTEMS_ERROR);
        }

        boolean firstArabicNumberIsCorrect = validationArabic.arabicNumberIsCorrect(firstNumber);
        boolean secondArabicNumberIsCorrect = validationArabic.arabicNumberIsCorrect(secondNumber);

        if ((!firstRomanNumberIsCorrect && !firstArabicNumberIsCorrect && !secondRomanNumberIsCorrect && !secondArabicNumberIsCorrect) ||
                (!firstRomanNumberIsCorrect && firstArabicNumberIsCorrect && !secondRomanNumberIsCorrect && !secondArabicNumberIsCorrect) ||
                (!firstRomanNumberIsCorrect && !firstArabicNumberIsCorrect && !secondRomanNumberIsCorrect && secondArabicNumberIsCorrect) || (firstRomanNumberIsCorrect && !firstArabicNumberIsCorrect && !secondRomanNumberIsCorrect && !secondArabicNumberIsCorrect) ||
                (!firstRomanNumberIsCorrect && !firstArabicNumberIsCorrect && secondRomanNumberIsCorrect && !secondArabicNumberIsCorrect)) {
            throw new ArithmeticException(INCORRECT_DATA_ENTERED_ERROR);
        }
    }
}
