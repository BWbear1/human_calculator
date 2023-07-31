public class CalculationStart {

    private final String NO_ZERO_IN_THE_ROMAN_NUMERAL_SYSTEM_ERROR = "т.к. в римской системе счисления отсутствуют числа <=0";
    public static RomanConvertToArabic romanConvertToArabic = new RomanConvertToArabic();
    public static ArabicConverterToRomanService arabicConverterToRomanService = new ArabicConverterToRomanService();
    public static ArabicNumberValidationService validationArabic = new ArabicNumberValidationService();
    CalculatorUtil calculiti = new CalculatorUtil();

    public String calculationStart(String firstNumber, String operator, String secondNumber) {
        boolean firstArabicNumberIsCorrect = validationArabic.arabicNumberIsCorrect(firstNumber);
        boolean secondArabicNumberIsCorrect = validationArabic.arabicNumberIsCorrect(secondNumber);

        if (secondArabicNumberIsCorrect && firstArabicNumberIsCorrect) {
            return Integer.toString(calculiti.calculation(operator, Integer.parseInt(firstNumber), Integer.parseInt(secondNumber)));
        }
        int result = calculiti.calculation(operator, romanConvertToArabic.convertRomanToArabicNumbers(firstNumber), romanConvertToArabic.convertRomanToArabicNumbers(secondNumber));

        if (result <= 0) {
            throw new ArithmeticException(NO_ZERO_IN_THE_ROMAN_NUMERAL_SYSTEM_ERROR);
        }
        return arabicConverterToRomanService.convert(result);
    }
}

