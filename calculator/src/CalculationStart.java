public class CalculationStart {
    private final String NO_ZERO_IN_THE_ROMAN_NUMERAL_SYSTEM = "т.к. в римской системе счисления отсутствуют числа <=0";
    public static RomanConvertToArabic romanConvertToArabic = new RomanConvertToArabic();
    public static ArabicConvertеrToRomanService arabicConvertеrToRomanService = new ArabicConvertеrToRomanService();
    public static ArabicNumberValidationService validationArabic = new ArabicNumberValidationService();

    public String calculationStart(String line1, String operator, String line2) {
        CalculatorUtil calculiti = new CalculatorUtil();
        boolean firstArabicNumberIsCorrect = validationArabic.arabicNumberIsCorrect(line1);
        boolean secondArabicNumberIsCorrect = validationArabic.arabicNumberIsCorrect(line2);

        if (secondArabicNumberIsCorrect && firstArabicNumberIsCorrect) {
            return Integer.toString(calculiti.calculation(operator, Integer.parseInt(line1), Integer.parseInt(line2)));
        }
        int itog = calculiti.calculation(operator, romanConvertToArabic.convertRomanToArabicNumbers(line1), romanConvertToArabic.convertRomanToArabicNumbers(line2));
        if (itog <= 0) {
            throw new ArithmeticException(NO_ZERO_IN_THE_ROMAN_NUMERAL_SYSTEM);
        }
        return arabicConvertеrToRomanService.convert(itog);

    }
}
