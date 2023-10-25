package Praktika;

import java.util.Arrays;

public class third_practice {
    public static void main(String[] args) {
        System.out.println(replaceVowels("apple"));
        System.out.println(replaceVowels("Even if you did this task not by yourself, you have to understand every single line of code."));
        System.out.println(stringTransform("hello"));
        System.out.println(stringTransform("bookkeeper"));
        System.out.println(doesBlockFit(1, 3, 5, 4, 5));
        System.out.println(doesBlockFit(1, 8, 1, 1, 1));
        System.out.println(doesBlockFit(1, 2, 2, 1, 1));
        System.out.println(numCheck(243));
        System.out.println(numCheck(52));
        System.out.println(countRoots(new int[]{1, -3, 2}));
        System.out.println(countRoots(new int[]{2, 5, 2}));
        System.out.println(countRoots(new int[]{1, -6, 9}));
        System.out.println(Arrays.toString(salesData(new String[][]{
                {"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Banana", "Shop2", "Shop3", "Shop4"},
                {"Orange", "Shop1", "Shop3", "Shop4"},
                {"Pear", "Shop2", "Shop4"}
        })));
        System.out.println(Arrays.toString(salesData((new String[][]{
                {"Fridge", "Shop2", "Shop3"},
                {"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Laptop", "Shop3", "Shop4"},
                {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}
        }))));
        System.out.println(validSplit("apple eagle egg goat"));
        System.out.println(validSplit("cat dog goose fish"));
        System.out.println(waveForm(new int[]{3, 1, 4, 2, 7, 5}));
        System.out.println(waveForm(new int[]{1, 2, 3, 4, 5}));
        System.out.println(waveForm(new int[]{1, 2, -6, 10, 3}));
        System.out.println(commonVowel("Hello World"));
        System.out.println(commonVowel("Actions speak louder than words."));
        System.out.println(Arrays.deepToString(dataScience(new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {5, 5, 5, 5, 5},
                {7, 4, 3, 14, 2},
                {1, 0, 11, 10, 1}
        })));
        System.out.println(Arrays.deepToString(dataScience(new int[][]{
                {6, 4, 19, 0, 0},
                {81, 25, 3, 1, 17},
                {48, 12, 60, 32, 14},
                {91, 47, 16, 65, 217},
                {5, 73, 0, 4, 21}
        })));
    }

    public static String replaceVowels(String str) {
        String vowels = "aeiouy";
        for (int i = 0; i < str.length(); i++) {
            if (vowels.contains("" + str.toLowerCase().charAt(i))) {
                str = str.replace(str.charAt(i), '*');
            }
        }
        return str;
    }

    public static String stringTransform(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                str = str.replace("" + str.charAt(i) + str.charAt(i + 1), "Double" + str.toUpperCase().charAt(i));
            }
        }
        return str;
    }
// ???
    public static boolean doesBlockFit(int a, int b, int c, int w, int h) {
        int[] izmer = new int[] {a, b, c};
        izmer = Arrays.stream(izmer).sorted().toArray();
        return (izmer[0] <= w && izmer[1] <= h) || (izmer[0] <= h && izmer[1] <= w);

//        return (a <= w && b <= h) || (a <= h && b <= w) || (a <= w && c <= h) ||
//                (a <= h && c <= w) || (b <= w && c <= h) || (b <= h && c <= w);
    }

    public static boolean numCheck(int digit) {
        int isOdd = digit % 2;
        int sumStep = 0;
        while (digit != 0) {
            sumStep += (digit % 10) * (digit % 10);
            digit /= 10;
        }
        return isOdd == sumStep % 2;
    }

    public static int countRoots(int[] coef) {
        int a = coef[0];
        int b = coef[1];
        int c = coef[2];
        int disc = b * b - 4 * a * c;
        double x_1 = (-b - Math.sqrt(disc)) / (2 * a);
        double x_2 = (-b + Math.sqrt(disc)) / (2 * a);
        int count = 0;
        if (x_1 != x_2) {
            if (x_1 % 1.0 == 0) {
                count += 1;
            }
            if (x_2 % 1.0 == 0) {
                count += 1;
            }
        } else {
            count = 1;
        }
        return count;
    }

    public static String[] salesData(String[][] data) {
        String result = "";
        int[] dataLens = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            dataLens[i] = data[i].length;
        }
        for (int i = 0; i < data.length; i++) {
            if (Arrays.stream(dataLens).max().getAsInt() == data[i].length) {
                result += data[i][0] + ' ';
            }
        }
        return result.split(" ");
    }

    public static boolean validSplit(String str) {
        int count = 0;
        String[] newStr = str.split(" ");
        for (int i = 0; i < newStr.length - 1; i++) {
            if (newStr[i].charAt(newStr[i].length() - 1) == newStr[i + 1].charAt(0)) {
                count += 1;
            }
        }
        return count == newStr.length - 1;
    }

    public static boolean waveForm(int[] digits) {
        for (int i = 0; i < digits.length - 2; i++) {
            if ((digits[i] <= digits[i + 1] && digits[i + 1] <= digits[i + 2]) ||
                    (digits[i] >= digits[i + 1] && digits[i + 1] >= digits[i + 2])) {
                return false;
            }
        }
        return true;
    }

    public static char commonVowel(String str) {
        int[] count = new int[6];
        char[] newStr = str.toLowerCase().toCharArray();
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};
        for (int i = 0; i < newStr.length; i++) {
            for (int j = 0; j < vowels.length; j++) {
                if (newStr[i] == vowels[j]) {
                    count[j] += 1;
                }
            }
        }
        int maxCount = 0;
        char result = ' ';
        for (int i = 0; i < count.length; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                result = vowels[i];
            }
        }
        return result;
    }

    public static int[][] dataScience(int[][] digits) {
        for (int i = 0; i < digits.length; i++) {
            int sum = 0;
            for (int j = 0; j < digits.length; j++) {
                if (j != i) {
                    sum += digits[j][i];
                }
            }
            digits[i][i] = (int) (Math.round((double) sum / (digits.length - 1)));
        }
        return digits;
    }

}

