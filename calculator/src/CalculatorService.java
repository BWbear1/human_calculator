import java.util.Scanner;


class CalculatorService {
    String ERROR1 = "т.к. введенная строка не является математической операцией";
    String ERROR2 = "т.к введены некорректные данные, допустимый диапазон значений [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10][I, II, III, IV, V, VI, VII, VIII, IX, X]";
    String ERROR3 = "т.к используются одновременно разные системы счисления";
    String ERROR4 = "т.к. в римской системе счисления отсутствуют числа <=0";

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
        Calculation calculiti = new Calculation();
        RomanConvertArabic romanConvertArabic1 = new RomanConvertArabic();
        ArabicConvertRoman arabicConvertRoman1 = new ArabicConvertRoman();
        RomanNumberValidationService validationRoman = new RomanNumberValidationService();
        ArabicNumberValidationService  validationArabic = new ArabicNumberValidationService ();
        boolean romanValidation1 = validationRoman.romanValidation(line1);
        boolean romanValidation2 = validationRoman.romanValidation(line2);
        boolean arabicValidation1 = validationArabic.arabicValidation(line1);
        boolean arabicValidation2 = validationArabic.arabicValidation(line2);
        if ((romanValidation1 && !arabicValidation1 && !romanValidation2 && arabicValidation2) || (!romanValidation1 && arabicValidation1 && romanValidation2 && !arabicValidation2)) // проверка инты+римляне
        {
            throw new ArithmeticException(ERROR3);
        }
        if ((!romanValidation1 && !arabicValidation1 && !romanValidation2 && !arabicValidation2) || (!romanValidation1 && arabicValidation1 && !romanValidation2 && !arabicValidation2) ||
                (!romanValidation1 && !arabicValidation1 && !romanValidation2 && arabicValidation2) || (romanValidation1 && !arabicValidation1 && !romanValidation2 && !arabicValidation2) ||
                (!romanValidation1 && !arabicValidation1 && romanValidation2 && !arabicValidation2)) // проверка на крокозябру
        {
            throw new ArithmeticException(ERROR2);
        }
        if (arabicValidation2 && arabicValidation1) {
            return Integer.toString(calculiti.calculation(operator, Integer.parseInt(line1), Integer.parseInt(line2)));
        }

        int itog = calculiti.calculation(operator, romanConvertArabic1.convertRomanToArabicNumbers(line1), romanConvertArabic1.convertRomanToArabicNumbers(line2));
        if (itog <= 0) {
            throw new ArithmeticException(ERROR4);
        }
        return arabicConvertRoman1.convert(itog);
    }
}

