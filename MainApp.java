import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение");
        Scanner sc = new Scanner(System.in);
        int a = 0;
        int b = 0;
        String op = "";
        String result;
        boolean isRoman;
        do {
            String input = sc.next();
            String[] strings = input.split("\\W");
            String[] operator = input.split("\\w");
            try {
                a = Integer.parseInt(strings[0]);
                b = Integer.parseInt(strings[1]);
                op = operator[operator.length - 1];
                if (a < 1 || b < 1 || a > 10 || b > 10) {
                    System.out.println("Число должно принимать значения от 1 до 10 включительно");
                    break;
                }
                if (operator.length != 2) {
                    System.out.println("Должно быть два операнда и один оператор");
                    break;
                }
                if (Roman.isRoman(strings[0]) && Roman.isRoman(strings[1])) {
                    a = Roman.convertToArabian(strings[0]);
                    b = Roman.convertToArabian(strings[1]);
                    isRoman = true;
                } else if (!Roman.isRoman(strings[0]) && !Roman.isRoman(strings[1])) {
                    a = Integer.parseInt(strings[0]);
                    b = Integer.parseInt(strings[1]);
                    isRoman = false;
                } else {
                    throw new Exception("Числа должны быть в одном формате");
                }
                int arabian = calc(a, b, op);
                if (isRoman) {
                    if (arabian <= 0) {
                        throw new Exception("Римское число должно быть больше нуля");
                    }
                    result = Roman.convertToRoman(arabian);
                } else {
                    result = String.valueOf(arabian);
                }
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println("Ответ = " + calc(a, b, op));
        }
        while (true);
    }

    private static int calc(int a, int b, String op) {
        switch (op) {
            case "*":
                return a * b;
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "/":
                return a / b;
            default:
                return 0;
        }
    }
}



    class Roman {
        static String[] romanArray = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
                "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
                "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
                "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
                "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
                "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
                "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
                "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
                "XCVIII", "XCIX", "C"};

        public static boolean isRoman(String val) {
            for (int i = 0; i < romanArray.length; i++) {
                if (val.equals(romanArray[i])) {
                    return true;
                }
            }
            return false;
        }

        public static int convertToArabian(String roman) {
            for (int i = 0; i < romanArray.length; i++) {
                if (roman.equals(romanArray[i])) {
                    return i;
                }
            }
            return -1;
        }

        public static String convertToRoman(int arabian) {
            return romanArray[arabian];
        }
    }


