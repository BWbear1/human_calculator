public class ArabicNumberValidationService2 {
    boolean arabicNumberIsCorrect2(String line1) {
        int number1;
        try {
            number1 = Integer.parseInt(line1);
            String[] massiv = line1.split("");
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}// проверка на интовость
