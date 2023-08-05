public class ValidationNumbers {
    private final static String INCORRECT_DATA_ENTERED_ERROR = "т.к введены некорректные данные, допустимый диапазон значений [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10][I, II, III, IV, V, VI, VII, VIII, IX, X]";
    private final static String DIFFERENT_NUMBER_SYSTEMS_ERROR = "т.к используются одновременно разные системы счисления";

    RomanNumberValidationService validationRoman = new RomanNumberValidationService();
    ArabicNumberValidationService validationArabic = new ArabicNumberValidationService();
    ArabicNumberValidationService validationArabicForFulfillTheTaskConditionsForDifferentNumberSystemsScyko = new ArabicNumberValidationService();


    public void validationNumbers(String firstNumber, String secondNumber) {
        boolean firstRomanNumberIsCorrect = validationRoman.isRomeNumberCorrect(firstNumber);
        boolean secondRomanNumberIsCorrect = validationRoman.isRomeNumberCorrect(secondNumber);
        boolean firstArabicNumberIsCorrectForFulfillTheTaskConditionsForDifferentNumberSystemsScyko =
                validationArabicForFulfillTheTaskConditionsForDifferentNumberSystemsScyko.arabicNumberIsCorrectForFulfillTheTaskConditionsForDifferentNumberSystemsScyko(firstNumber);///
        boolean secondArabicNumberIsCorrectForFulfillTheTaskConditionsForDifferentNumberSystemsScyko =
                validationArabicForFulfillTheTaskConditionsForDifferentNumberSystemsScyko.arabicNumberIsCorrectForFulfillTheTaskConditionsForDifferentNumberSystemsScyko(secondNumber);////

        if ((firstRomanNumberIsCorrect && !firstArabicNumberIsCorrectForFulfillTheTaskConditionsForDifferentNumberSystemsScyko &&
                !secondRomanNumberIsCorrect && secondArabicNumberIsCorrectForFulfillTheTaskConditionsForDifferentNumberSystemsScyko) ||
                (!firstRomanNumberIsCorrect &&
                firstArabicNumberIsCorrectForFulfillTheTaskConditionsForDifferentNumberSystemsScyko && secondRomanNumberIsCorrect &&
                        !secondArabicNumberIsCorrectForFulfillTheTaskConditionsForDifferentNumberSystemsScyko)) {
            throw new ArithmeticException(DIFFERENT_NUMBER_SYSTEMS_ERROR);
        }

        boolean firstArabicNumberIsCorrect = validationArabic.arabicNumberIsCorrectForFulfillTheTaskConditionsForDifferentNumberSystemsScyko(firstNumber);
        boolean secondArabicNumberIsCorrect = validationArabic.arabicNumberIsCorrectForFulfillTheTaskConditionsForDifferentNumberSystemsScyko(secondNumber);

        if ((!firstRomanNumberIsCorrect && !firstArabicNumberIsCorrect && !secondRomanNumberIsCorrect && !secondArabicNumberIsCorrect) ||
                (!firstRomanNumberIsCorrect && firstArabicNumberIsCorrect && !secondRomanNumberIsCorrect && !secondArabicNumberIsCorrect) ||
                (!firstRomanNumberIsCorrect && !firstArabicNumberIsCorrect && !secondRomanNumberIsCorrect && secondArabicNumberIsCorrect) ||
                (firstRomanNumberIsCorrect && !firstArabicNumberIsCorrect && !secondRomanNumberIsCorrect && !secondArabicNumberIsCorrect) ||
                (!firstRomanNumberIsCorrect && !firstArabicNumberIsCorrect && secondRomanNumberIsCorrect && !secondArabicNumberIsCorrect)) {
            throw new ArithmeticException(INCORRECT_DATA_ENTERED_ERROR);
        }
    }
}
