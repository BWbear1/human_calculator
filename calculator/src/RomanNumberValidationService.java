public class RomanNumberValidationService {
    private final static String[] WHITE_LIST_CHARACTER = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

    public boolean isRomeNumberCorrect(String number) {
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