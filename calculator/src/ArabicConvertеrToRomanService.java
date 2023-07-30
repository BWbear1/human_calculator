public class ArabicConvertеrToRomanService {
    private String selectionOfRomanNumber(int number, String one, String five, String ten) {
        switch (number) {
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

    public String convert(int itog) {

        String romanOnes = selectionOfRomanNumber(itog % 10, "I", "V", "X");
        itog /= 10;
        String romanTens = selectionOfRomanNumber(itog % 10, "X", "L", "C");
        itog /= 10;
        String romanHundreds = selectionOfRomanNumber(itog % 10, "C", "D", "M");
        return romanHundreds + romanTens + romanOnes;

    }
}
