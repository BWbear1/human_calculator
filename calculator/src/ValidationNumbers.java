public class ValidationNumbers {
    RomanNumberValidationService validationRoman = new RomanNumberValidationService();
    ArabicNumberValidationService validationArabic = new ArabicNumberValidationService();
    ArabicNumberValidationService2 validationArabic2 = new ArabicNumberValidationService2();
    private final String INCORRECT_DATA_ENTERED_ERROR = "т.к введены некорректные данные, допустимый диапазон значений [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10][I, II, III, IV, V, VI, VII, VIII, IX, X]";
    private final String DIFFERENT_NUMBER_SYSTEMS_ERROR = "т.к используются одновременно разные системы счисления";

    public void validationNumbers(String line1, String line2) {
        boolean firstRomanNumberIsCorrect = validationRoman.isRomeNumberCorrect(line1);
        boolean secondRomanNumberIsCorrect = validationRoman.isRomeNumberCorrect(line2);
        boolean firstArabicNumberIsCorrect2 = validationArabic2.arabicNumberIsCorrect2(line1);
        boolean secondArabicNumberIsCorrect2 = validationArabic2.arabicNumberIsCorrect2(line2);

        if ((firstRomanNumberIsCorrect && !firstArabicNumberIsCorrect2 && !secondRomanNumberIsCorrect && secondArabicNumberIsCorrect2) || (!firstRomanNumberIsCorrect &&
                firstArabicNumberIsCorrect2 && secondRomanNumberIsCorrect && !secondArabicNumberIsCorrect2)) {
            throw new ArithmeticException(DIFFERENT_NUMBER_SYSTEMS_ERROR);
        }

        boolean firstArabicNumberIsCorrect = validationArabic.arabicNumberIsCorrect(line1);
        boolean secondArabicNumberIsCorrect = validationArabic.arabicNumberIsCorrect(line2);

        if ((!firstRomanNumberIsCorrect && !firstArabicNumberIsCorrect && !secondRomanNumberIsCorrect && !secondArabicNumberIsCorrect) ||
                (!firstRomanNumberIsCorrect && firstArabicNumberIsCorrect && !secondRomanNumberIsCorrect && !secondArabicNumberIsCorrect) ||
                (!firstRomanNumberIsCorrect && !firstArabicNumberIsCorrect && !secondRomanNumberIsCorrect && secondArabicNumberIsCorrect) || (firstRomanNumberIsCorrect && !firstArabicNumberIsCorrect && !secondRomanNumberIsCorrect && !secondArabicNumberIsCorrect) ||
                (!firstRomanNumberIsCorrect && !firstArabicNumberIsCorrect && secondRomanNumberIsCorrect && !secondArabicNumberIsCorrect)) {
            throw new ArithmeticException(INCORRECT_DATA_ENTERED_ERROR);
        }
    }
}
