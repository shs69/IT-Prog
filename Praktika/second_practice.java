package Praktika;

import java.lang.Math;
import java.util.Arrays;
import java.util.Random;

public class second_practice {
    public static void main(String[] args) {

        System.out.println(duplicateChars("Donald"));
        System.out.println(duplicateChars("orange"));

        System.out.println(getInitials("Ryan Gosling"));
        System.out.println(getInitials("Barack Obama"));

        System.out.println(differenceEvenOdd(new int[]{44, 32, 86, 19}));
        System.out.println(differenceEvenOdd(new int[]{22, 50, 16, 63, 31, 55}));

        System.out.println(equalToAvq(new int[]{1, 2, 3, 4, 5}));
        System.out.println(equalToAvq(new int[]{1, 2, 3, 4, 6}));

        System.out.println((Arrays.toString(indexMult(new int[]{1, 2, 3}))));
        System.out.println((Arrays.toString(indexMult(new int[]{3, 3, -2, 408, 3, 31}))));

        System.out.println(reverse("Hello World"));
        System.out.println(reverse("The quick brown fox."));

        System.out.println(Tribonacci(7));
        System.out.println(Tribonacci(11));

        System.out.println(pseudoHash(5));
        System.out.println(pseudoHash(10));
        System.out.println(pseudoHash(0));

        System.out.println(botHelper("Hello, I’m under the water, please help me"));
        System.out.println(botHelper("Two pepperoni pizzas please"));

        System.out.println(isAnagram("listen", "silent"));
        System.out.println(isAnagram("eleven plus two", "twelve plus one"));
        System.out.println(isAnagram("hello", "world"));
    }

    public static boolean duplicateChars(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.toLowerCase().charAt(i) == str.toLowerCase().charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String getInitials(String name) {
        return ("" + name.split(" ")[0].charAt(0) + name.split(" ")[1].charAt(0));
    }

    public static int differenceEvenOdd(int[] numbers) {
        int evenSum = 0, oddSum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evenSum += numbers[i];
            } else {
                oddSum += numbers[i];
            }
        }
        return (Math.abs(evenSum - oddSum));
    }

    public static boolean equalToAvq(int[] numbers) {
        float arithSum = 0;
        for (int i = 0; i < numbers.length; i++) {
            arithSum += numbers[i];
        }
        for (int i = 0; i < numbers.length; i++) {
            if ((arithSum / numbers.length) == numbers[i]) {
                return true;
            }
        }
        return false;
    }

    public static int[] indexMult(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] *= i;
        }
        return numbers;
    }

    public static String reverse(String str) {
        String newStr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            newStr += str.charAt(i);
        }
        return newStr;
    }

    public static int Tribonacci(int position) {
        if (position <= 2) {
            return 0;
        } else if (position == 3) {
            return 1;
        } else {
            return Tribonacci(position - 1) + Tribonacci(position - 2) + Tribonacci(position - 3);
        }
    }

    public static String pseudoHash(int len) {
        String newHash = "";
        char[] symbol = {'a', 'b', 'c', 'd', 'e', 'f', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        if (len != 0) {
            for (int i = 0; i < len; i++) {
                newHash += symbol[new Random().nextInt(symbol.length)];
            }
        }
        return newHash;
    }

    public static String botHelper(String str) {
        str = str.toLowerCase();
        for (int i = 0; i < str.length() - 3; i++) {
            if (str.charAt(i) == 'h' & str.charAt(i + 1) == 'e' & str.charAt(i + 2) == 'l' & str.charAt(i + 3) == 'p') {
                return "Calling for a staff manager";
            }
        }
        return "Keep waiting";
    }

    public static boolean isAnagram(String first_word, String second_word) {
        String[] first_sym = first_word.toLowerCase().split("");
        String[] second_sym = second_word.toLowerCase().split("");
        Arrays.sort(first_sym);
        Arrays.sort(second_sym);

        return Arrays.equals(first_sym, second_sym);
    }
}
