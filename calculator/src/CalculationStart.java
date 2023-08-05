public class CalculationStart {

    private final static String NO_ZERO_IN_THE_ROMAN_NUMERAL_SYSTEM_ERROR = "т.к. в римской системе счисления отсутствуют числа <=0";
    public static RomanConvertToArabic romanConvertToArabic = new RomanConvertToArabic();
    public static ArabicConverterToRomanService arabicConverterToRomanService = new ArabicConverterToRomanService();
    public static ArabicNumberValidationService validationArabic = new ArabicNumberValidationService();
    CalculatorUtil calculiti = new CalculatorUtil();

    public String calculationStart(String firstNumber, String operator, String secondNumber) {
        boolean firstArabicNumberIsCorrect = validationArabic.arabicNumberIsCorrectForFulfillTheTaskConditionsForDifferentNumberSystemsScyko(firstNumber);
        boolean secondArabicNumberIsCorrect = validationArabic.arabicNumberIsCorrectForFulfillTheTaskConditionsForDifferentNumberSystemsScyko(secondNumber);

        if (secondArabicNumberIsCorrect && firstArabicNumberIsCorrect) {
            return Integer.toString(calculiti.selectOperatorAndCalculate(operator, Integer.parseInt(firstNumber), Integer.parseInt(secondNumber)));
        }
        int result = calculiti.selectOperatorAndCalculate(operator, romanConvertToArabic.convertRomanToArabicNumbers(firstNumber), romanConvertToArabic.convertRomanToArabicNumbers(secondNumber));

        if (result <= 0) {
            throw new ArithmeticException(NO_ZERO_IN_THE_ROMAN_NUMERAL_SYSTEM_ERROR);
        }
        return arabicConverterToRomanService.convertToRomanNumeral(result);
    }
}

