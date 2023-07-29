class ArabicConvertRoman {
    String romanDigit(int number, String one, String five, String ten) {
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

    String convert(int ITOG) {

        String romanOnes = romanDigit(ITOG % 10, "I", "V", "X");
        ITOG /= 10;
        String romanTens = romanDigit(ITOG % 10, "X", "L", "C");
        ITOG /= 10;
        String romanHundreds = romanDigit(ITOG % 10, "C", "D", "M");
        return romanHundreds + romanTens + romanOnes;

    }
}
