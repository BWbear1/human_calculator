import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String line1;
        String operator1;
        String line2;
        System.out.println("Введите уравнение:");
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        line1 = input[0];
        if (input.length > 1) {
            operator1 = input[1];

        } else {
            throw new RuntimeException("т.к. введенная строка не является математической операцией");
        }
        if (input.length > 2) {
            line2 = input[2];
        } else {
            throw new RuntimeException("т.к. введенная строка не является математической операцией");
        }
        CalculatorService calc = new CalculatorService();
        String result = calc.init(line1, operator1, line2);
        System.out.println("Результат:" + result);


    }
}

class CalculatorService {
    String init(String n1, String op, String n2) {
        String line1;
                line1 = n1;
        String operator;
                operator = op;
        String line2;
                line2 = n2;
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
            throw new ArithmeticException("т.к используются одновременно разные системы счисления");
        }
        if ((!romanValidation1 && !arabicValidation1 && !romanValidation2 && !arabicValidation2) || (!romanValidation1 && arabicValidation1 && !romanValidation2 && !arabicValidation2) || (!romanValidation1 && !arabicValidation1 && !romanValidation2 && arabicValidation2) || (romanValidation1 && !arabicValidation1 && !romanValidation2 && !arabicValidation2) || (!romanValidation1 && !arabicValidation1 && romanValidation2 && !arabicValidation2)) // проверка на крокозябру
        {
            throw new ArithmeticException("т.к введены некорректные данные, допустимый диапазон значений [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10][I, II, III, IV, V, VI, VII, VIII, IX, X]");
        }
        if (arabicValidation2 && arabicValidation1) {
            int number1 = Integer.parseInt(line1);
            int number2 = Integer.parseInt(line2);
            int itog = calculiti.calculation(operator, number1, number2);
            return Integer.toString(itog);
        } else {
            int number1 = romanConvertArabic1.romanConverting(line1);
            int number2 = romanConvertArabic1.romanConverting(line2);
            int itog = calculiti.calculation(operator, number1, number2);
            if (itog <= 0) {
                throw new ArithmeticException("т.к. в римской системе счисления отсутствуют числа <=0");
            }
            return arabicConvertRoman1.convert(itog);
        }
    }
}


class Calculation {
    int calculation(String operator, int number1, int number2) //считалочка
    {
        int ITOG;
        switch (operator) {
            case "+":
                ITOG = number1 + number2;
                break;
            case "-":
                ITOG = number1 - number2;
                break;
            case "*":
                ITOG = number1 * number2;
                break;
            case "/": {
                ITOG = number1 / number2;
            }
            break;
            default:
                throw new IllegalArgumentException("Т.к не коректно введен оператор в уравнении");
        }
        return ITOG;
    }
}

class ArabicNumberValidationService  {
    boolean arabicValidation(String line1) {
        int number1;
        try {
            number1 = Integer.parseInt(line1);
            String[] massiv = line1.split(""); // проверка на нолик в начале
            if (massiv[0].equals("0") || number1 > 10 || number1 < 1) {
                throw new ArithmeticException("т.к допустимый диапазон значений [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]");
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}// проверка на интовость

class RomanNumberValidationService{
    boolean romanValidation(String line1) {  // для проверки
        if (line1.equals("I") || line1.equals("II") || line1.equals("III") || line1.equals("IV") || line1.equals("V") || line1.equals("VI") || line1.equals("VII") || line1.equals("VIII") || line1.equals("IX") || line1.equals("X"))
        {
            return true;
        }
            return false;
    }
} // проверка на то что число римское

class RomanConvertArabic {
    int romanConverting(String line1) { // перевод римлян в арабов
        int number1 = 0;
        int[] decimal = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < decimal.length; i++) {
            while (line1.indexOf(roman[i]) == 0) {
                number1 += decimal[i];
                line1 = line1.substring(roman[i].length());
            }
        }
        if (line1 == null || line1.isEmpty() || line1.trim().isEmpty()) {
            return number1;
        } else {
            throw new RuntimeException("т.к допустимый диапазон значений [I, II, III, IV, V, VI, VII, VIII, IX, X]");
        }
    }
}//перевод римлян в арабов для вычислений

class ArabicConvertRoman {
    String romanDigit(int n, String one, String five, String ten) {
        switch (n) {
            case 1:
                return one;
            case 2:
                return one + one;
            case 3:
                return one + one + one;
            case 4:
                return one + five;
            case 5:
                return five;
            case 6:
                return five + one;
            case 7:
                return five + one + one;
            case 8:
                return five + one + one + one;
            case 9:
                return one + ten;
            default:
                return "";

        }
    }

    //часть 1 перевода арабов в римлян

    String convert(int ITOG) {

        String romanOnes = romanDigit(ITOG % 10, "I", "V", "X");
        ITOG /= 10;
        String romanTens = romanDigit(ITOG % 10, "X", "L", "C");
        ITOG /= 10;
        String romanHundreds = romanDigit(ITOG % 10, "C", "D", "M");
        return romanHundreds + romanTens + romanOnes;

    }
}
