//class RomanNumberValidationService {
//    // для проверки
//    boolean romanValidation(String line1) {
//        return line1.equals("I") || line1.equals("II") || line1.equals("III") || line1.equals("IV") || line1.equals("V") || line1.equals("VI") || line1.equals("VII") || line1.equals("VIII") || line1.equals("IX") || line1.equals("X");
//    }
//} // проверка на то что число римское
class RomanNumberValidationService {

    private final static String[] WHITE_LIST_CHARACTER = {"I", "II", "III", "IV", "V", "VI","VII", "VIII", "IX", "X"};

    public boolean isRomeNumberCorrect (String number) {
        return checkRomeNumberOnWhiteList(number);
    }

    private boolean checkRomeNumberOnWhiteList(String number) {  // для проверки
        for (String s : WHITE_LIST_CHARACTER) {
            if (number.equals(s)) {
                return true;
            }
        }
        return false;
    }
}