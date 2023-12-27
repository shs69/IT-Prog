package Praktika;

import java.util.*;

public class sixth_practice {
    public static void main(String[] args) {
        System.out.println("Задание 1:");
        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived"));
        System.out.println(hiddenAnagram("An old west action hero actor", "Clint Eastwood"));
        System.out.println(hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison"));
        System.out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM"));
        System.out.println(hiddenAnagram("D  e b90it->?$ (c)a r...d,,#~", "bad credit"));
        System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth"));

        System.out.println('\n' + "Задание 2:");
        System.out.println(collect("intercontinentalisationalism", 6));
        System.out.println(collect("strengths", 3));
        System.out.println(collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15));

        System.out.println('\n' + "Задание 3:");
        System.out.println(nicoCipher("myworldevolvesinhers", "tesh"));
        System.out.println(nicoCipher("andiloveherso", "tesha"));
        System.out.println(nicoCipher("mubashirhassan", "crazy"));
        System.out.println("'" + nicoCipher("edabitisamazing", "matt") + "'");
        System.out.println(nicoCipher("iloveher", "612345"));

        System.out.println('\n' + "Задание 4:");
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 9, 4, 5, 15}, 45)));
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 9, 4, 15, 3, 5}, 45)));
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, -1, 4, 5, 6, 10, 7}, 20)));
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10)));
        System.out.println(Arrays.toString(twoProduct(new int[]{100, 12, 4, 1, 2}, 15)));


        System.out.println('\n' + "Задание 5:");
        System.out.println(Arrays.toString(isExact(6)));
        System.out.println(Arrays.toString(isExact(24)));
        System.out.println(Arrays.toString(isExact(125)));
        System.out.println(Arrays.toString(isExact(720)));
        System.out.println(Arrays.toString(isExact(1024)));
        System.out.println(Arrays.toString(isExact(40320)));

        System.out.println('\n' + "Задание 6:");
        System.out.println(fractions("0.(6)"));
        System.out.println(fractions("1.(1)"));
        System.out.println(fractions("3.(142857)"));
        System.out.println(fractions("0.19(2367)"));
        System.out.println(fractions("0.1097(3)"));

        System.out.println('\n' + "Задание 7:");
        System.out.println(pilish_string("3331444"));
        System.out.println(pilish_string("TOP"));
        System.out.println(pilish_string("X"));
        System.out.println(pilish_string(""));

        System.out.println('\n' + "Задание 8:");
        System.out.println(generateNonconsecutive("3 + 5 * (2 - 6)"));
        System.out.println(generateNonconsecutive("6 - 18 / (-1 + 4)"));
        System.out.println(generateNonconsecutive("2 + 5 / 0"));
        System.out.println(generateNonconsecutive(""));

        System.out.println('\n' + "Задание 9:");
        System.out.println(isValid("aabbcd"));
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(isValid("abcdefghhgfedecba"));

        System.out.println("\n" + "Задание 10:");
        System.out.println(findLCS("abcd", "bd"));
        System.out.println(findLCS("aggtab", "gxtxamb"));
    }

    public static String hiddenAnagram(String firstString, String secondString) {
        firstString = firstString.toLowerCase().replaceAll("[^a-z]", "");
        secondString = secondString.toLowerCase().replaceAll("[^a-z]", "");

        for (int i = 0; i <= firstString.length() - secondString.length(); i++) {
            String string = firstString.substring(i, i + secondString.length());
            if (second_practice.isAnagram(secondString, string)) {
                return string;
            }
        }

        return "notfound";
    }

    public static String collect(String string, int count) {
        List<String> list;
        list = collectRec(string, count, new ArrayList<>());
        return list.toString();
    }

    public static List<String> collectRec(String string, int count, List<String> array) {

        if (string.length() >= count) {
            String buffer = string.substring(0, count);
            array.add(buffer);
//            array.sort(new Comparator<String>() {
//                @Override
//                public int compare(String o1, String o2) {
//                    return o1.compareTo(o2);
//                }
//            });
            array.sort(Comparator.naturalOrder());
            collectRec(string.substring(count), count, array);
        }

        return array;
    }

    public static String nicoCipher(String message, String key) {

        int[] keyOrder = new int[key.length()];
        for (int i = 0; i < key.length(); i++) {
            keyOrder[i] = key.charAt(i) - 'a' + 1;
        }

        int numRows = message.length() / key.length() + (message.length() % key.length() == 0 ? 0 : 1);
        char[][] matrix = new char[numRows][key.length()];
        int index = 0;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < key.length(); j++) {
                if (index < message.length()) {
                    matrix[i][j] = message.charAt(index++);
                } else {
                    matrix[i][j] = ' ';
                }
            }
        }

        for (int i = 1; i <= key.length(); i++) {
            for (int j = 0; j < key.length() - i; j++) {
                if (keyOrder[j] > keyOrder[j + 1]) {

                    int temp = keyOrder[j];
                    keyOrder[j] = keyOrder[j + 1];
                    keyOrder[j + 1] = temp;

                    for (int k = 0; k < numRows; k++) {
                        char tempChar = matrix[k][j];
                        matrix[k][j] = matrix[k][j + 1];
                        matrix[k][j + 1] = tempChar;
                    }
                }
            }
        }

        StringBuilder encodedMessage = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < key.length(); j++) {
                encodedMessage.append(matrix[i][j]);
            }
        }

        return encodedMessage.toString();
    }

    public static int[] twoProduct(int[] array, int n) {
        int gap = 99999;
        int[] result = new int[2];
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] * array[j] == n) {
                    if (j - i < gap) {
                        result[0] = array[i];
                        result[1] = array[j];
                        gap = j - i;
                    }
                }
            }
        }
        if (result[0] == 0) {
            return new int[0];
        }
        return result;
    }

    public static int[] isExact(int n) {
        int fact = 0;
        int i = 0;
        int[] res = new int[]{};
        while (fact < n) {
            i++;
            fact = first_practice.factorial(i);
        }
        if (fact == n) {
            res = new int[]{n, i};
        }
        return res;
    }

    public static String fractions(String decimal) {
        String periodicPart = decimal.substring(decimal.indexOf('(') + 1, decimal.indexOf(')'));
        String beforePeriodicPart = decimal.substring(0, decimal.indexOf('('));
        String integerPart = decimal.substring(decimal.indexOf('.') + 1, decimal.indexOf('('));

        int denominator = Integer.parseInt(makeDenom(periodicPart.length(), integerPart.length()));
        int numerator = Integer.parseInt(decimal.replace(".", "").replace("(", "").replace(")", ""))
                - Integer.parseInt(beforePeriodicPart.replaceAll("\\.", ""));
        int nod = findNOD(numerator, denominator);
        numerator /= nod;
        denominator /= nod;

        return numerator + "/" + denominator;
    }

    public static String makeDenom(int first, int second) {
        String res = "";
        for (int i = 0; i < first; i++) {
            res += "9";
        }
        for (int i = 0; i < second; i++) {
            res += "0";
        }
        return res;
    }

    private static int findNOD(int num1, int num2) {
        int max = Integer.max(num1, num2);
        for (int i = max; i > 1; i--) {
            if (num1 % i == 0 && num2 % i == 0) {
                return i;
            }
        }
        return 1;
    }

    public static String pilish_string(String string) {
        if (string.isEmpty()) {
            return string;
        }

        ArrayList<String> list = new ArrayList<>();
        double pi = Math.PI;
        char[] piChars = String.valueOf(pi).toCharArray();
        char[] charsOfString = string.toCharArray();
        int startInd = 0;

        for (char i : piChars) {
            if (i != '.') {

                int length = Integer.parseInt(String.valueOf(i));
                int counter = 0;
                StringBuilder temp = new StringBuilder();

                if (startInd >= charsOfString.length) {
                    break;
                }

                for (int j = startInd; j < startInd + length; j++) {
                    if (j < charsOfString.length) {
                        temp.append(charsOfString[j]);
                    } else {
                        int lenRep = length - counter;
                        temp.append(temp.substring(temp.length() - 1).repeat(lenRep));
                        break;
                    }
                    counter += 1;
                    if (counter == length) {
                        break;
                    }
                }

                list.add(temp.toString());
                startInd += Integer.parseInt(String.valueOf(i));

            }
        }
        StringBuilder out = new StringBuilder();
        for (String i : list) {
            out.append(" ").append(i);
        }
        return out.substring(1);
    }

    public static String generateNonconsecutive(String str) {

        if (str.isEmpty()) {
            return "Вы ничего не ввели";
        }

        str = str.replaceAll("\\(", " ( ").replaceAll("\\)", " ) ");
        String[] array = str.split(" ");
        ArrayList<String> list = new ArrayList<>(Arrays.asList(array));

        while (list.contains("")) {
            list.remove("");
        }

        evaluateExpression(list);

        return String.valueOf(list.get(0));
    }

    private static ArrayList<String> evaluateExpression(ArrayList<String> list) {

        while (list.contains("(")) {
            int openIndex = list.lastIndexOf("(");
            int closeIndex = 0;
            for (int i = openIndex + 1; i < list.size(); i++) {
                if (list.get(i).equals(")")) {
                    closeIndex = i;
                    break;
                }
            }

            ArrayList<String> subList = new ArrayList<>(list.subList(openIndex + 1, closeIndex));

            String result = evaluateExpression(subList).get(0);

            if (result.equals("На ноль делить нельзя")) {
                list.clear();
                list.add("На ноль делить нельзя");
                return list;
            }

            replaceSubListToResult(list, result, openIndex, closeIndex);

        }

        evaluateOperation(list, "*");
        evaluateOperation(list, "/");
        evaluateOperation(list, "+");
        evaluateOperation(list, "-");

        return list;
    }

    private static void replaceSubListToResult(ArrayList<String> list, String replaceStr, int firstInd, int lastInd) {
        list.subList(firstInd, lastInd + 1).clear();
        list.add(firstInd, replaceStr);
    }

    private static void evaluateOperation(ArrayList<String> list, String operator) {

        while (list.contains(operator)) {
            int index = list.indexOf(operator);

            if (operator.equals("-") && (index == 0 || list.get(index - 1).equals("("))) {
                double operand = Double.parseDouble(list.get(index + 1));
                double result = -operand;
                list.remove(index);
                list.remove(index);
                list.add(index, String.valueOf(result));

            } else {
                double first = Double.parseDouble(list.get(index - 1));
                double second = Double.parseDouble(list.get(index + 1));
                double result = 0;

                switch (operator) {
                    case "*":
                        result = first * second;
                        break;
                    case "/":
                        if (second != 0) {
                            result = first / second;
                        } else {
                            list.clear();
                            list.add("На ноль делить нельзя");
                            return;
                        }

                        break;
                    case "+":
                        result = first + second;
                        break;
                    case "-":
                        result = first - second;
                        break;
                }

                replaceSubListToResult(list, String.valueOf(result), index - 1, index + 1);
            }
        }
    }

    public static String isValid(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();

        for (char i : chars) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        Integer[] nums = map.values().toArray(new Integer[0]);
        Arrays.sort(nums);
        boolean flag = true;
        Integer first = nums[0];

        for (int i = 0; i < nums.length - 1; i++) {
            if (!Objects.equals(first, nums[i])) {
                flag = false;
                break;
            }
        }

        if (!nums[nums.length - 1].equals(first + 1) && !nums[nums.length - 1].equals(first)) {
            flag = false;
        }
        return flag ? "YES" : "NO";
    }

    public static String findLCS(String str1, String str2) {
        String[][] matrix = new String[str1.length() + 1][str2.length() + 1];
        for (String[] arr : matrix) {
            Arrays.fill(arr, "");
        }
        for (int i = matrix.length - 2; i >= 0; i--) {
            for (int j = matrix[i].length - 2; j >= 0; j--) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    matrix[i][j] = str1.charAt(i) + matrix[i + 1][j + 1];
                } else {
                    if (matrix[i][j + 1].length() > matrix[i + 1][j].length()) {
                        matrix[i][j] = matrix[i][j + 1];
                    } else {
                        matrix[i][j] = matrix[i + 1][j];
                    }
                }
            }
        }
        return matrix[0][0];
    }
}
