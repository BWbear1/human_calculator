class RomanConvertArabic {
//    int[] DECIMAL = {100, 90, 50, 40, 10, 9, 5, 4, 1};
//    String[] ROMAN = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    int convertRomanToArabicNumbers(String line1) { // перевод римлян в арабов
        int number1 = 0;
        int[] DECIMAL = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] ROMAN = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < DECIMAL.length; i++) {
            while (line1.indexOf(ROMAN[i]) == 0) {
                number1 += DECIMAL[i];
                line1 = line1.substring(ROMAN[i].length());
            }
        }
        if (line1 == null || line1.isEmpty() || line1.trim().isEmpty()) {
            return number1;
        } else {
            throw new RuntimeException("т.к допустимый диапазон значений [I, II, III, IV, V, VI, VII, VIII, IX, X]");
        }
    }
}//перевод римлян в арабов для вычислений
