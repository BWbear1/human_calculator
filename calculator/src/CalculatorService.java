import java.util.Scanner;


class CalculatorService {

    String ERROR1 = "т.к. введенная строка не является математической операцией";

    //    String ERROR2 = "т.к введены некорректные данные, допустимый диапазон значений [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10][I, II, III, IV, V, VI, VII, VIII, IX, X]";
//    String ERROR3 = "т.к используются одновременно разные системы счисления";
//    String ERROR4 = "т.к. в римской системе счисления отсутствуют числа <=0";
//    //
    String init() {
        System.out.println("Введите уравнение:");
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        if (input.length < 2 || input.length > 3) {
            throw new RuntimeException(ERROR1);
        }
        String line1 = input[0];
        String operator = input[1];
        String line2 = input[2];
        ValidationNumbers numbersCheck = new ValidationNumbers();
        numbersCheck.validationNumbers(line1, line2);
        CalculationStart c2 = new CalculationStart();
        return c2.calculationStart(line1, operator, line2);
    }
}


class ValidationNumbers {


    RomanNumberValidationService validationRoman = new RomanNumberValidationService();
    ArabicNumberValidationService validationArabic = new ArabicNumberValidationService();
    String ERROR2 = "т.к введены некорректные данные, допустимый диапазон значений [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10][I, II, III, IV, V, VI, VII, VIII, IX, X]";
    String ERROR3 = "т.к используются одновременно разные системы счисления";


    void validationNumbers(String line1, String line2) {

        boolean firstRomanNumberIsCorrect = validationRoman.isRomeNumberCorrect(line1);
        boolean secondRomanNumberIsCorrect = validationRoman.isRomeNumberCorrect(line2);
        boolean firstArabicNumberIsCorrect = validationArabic.arabicValidation(line1);
        boolean secondArabicNumberIsCorrect = validationArabic.arabicValidation(line2);
        // проверка инты+римляне
        if ((firstRomanNumberIsCorrect && !firstArabicNumberIsCorrect && !secondRomanNumberIsCorrect && secondArabicNumberIsCorrect) || (!firstRomanNumberIsCorrect &&
                firstArabicNumberIsCorrect && secondRomanNumberIsCorrect && !secondArabicNumberIsCorrect)) {
            throw new ArithmeticException(ERROR3);
        }
        // проверка на крокозябру
        if ((!firstRomanNumberIsCorrect && !firstArabicNumberIsCorrect && !secondRomanNumberIsCorrect && !secondArabicNumberIsCorrect) || (!firstRomanNumberIsCorrect && firstArabicNumberIsCorrect && !secondRomanNumberIsCorrect && !secondArabicNumberIsCorrect) ||
                (!firstRomanNumberIsCorrect && !firstArabicNumberIsCorrect && !secondRomanNumberIsCorrect && secondArabicNumberIsCorrect) || (firstRomanNumberIsCorrect && !firstArabicNumberIsCorrect && !secondRomanNumberIsCorrect && !secondArabicNumberIsCorrect) ||
                (!firstRomanNumberIsCorrect && !firstArabicNumberIsCorrect && secondRomanNumberIsCorrect && !secondArabicNumberIsCorrect)) {
            throw new ArithmeticException(ERROR2);
        }
    }
}

class CalculationStart {
    String ERROR4 = "т.к. в римской системе счисления отсутствуют числа <=0";
    RomanConvertToArabic romanConvertToArabic = new RomanConvertToArabic();
    ArabicConvertToRoman arabicConvertToRoman = new ArabicConvertToRoman();
    //RomanNumberValidationService validationRoman = new RomanNumberValidationService();
    ArabicNumberValidationService validationArabic = new ArabicNumberValidationService();
    String calculationStart(String line1, String operator, String line2) {
        Calculation calculiti = new Calculation();

//        boolean firstRomanNumberIsCorrect = validationRoman.isRomeNumberCorrect(line1);
//        boolean secondRomanNumberIsCorrect = validationRoman.isRomeNumberCorrect(line2);
        boolean firstArabicNumberIsCorrect = validationArabic.arabicValidation(line1);
        boolean secondArabicNumberIsCorrect = validationArabic.arabicValidation(line2);

        if (secondArabicNumberIsCorrect && firstArabicNumberIsCorrect) {
            return Integer.toString(calculiti.calculation(operator, Integer.parseInt(line1), Integer.parseInt(line2)));
        }
            int itog = calculiti.calculation(operator, romanConvertToArabic.convertRomanToArabicNumbers(line1), romanConvertToArabic.convertRomanToArabicNumbers(line2));
            if (itog <= 0) {
                throw new ArithmeticException(ERROR4);
            }
            return arabicConvertToRoman.convert(itog);

    }
}
