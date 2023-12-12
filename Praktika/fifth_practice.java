package Praktika;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class fifth_practice {
    public static void main(String[] args) {
        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println(sameLetterPattern("FFFF", "ABCD"));

        System.out.println();
        System.out.println(spiderVsFly("H3", "E2"));
        System.out.println(spiderVsFly("A4", "B2"));
        System.out.println(spiderVsFly("A4", "C2"));

        System.out.println();
        System.out.println(digitsCount(4666));
        System.out.println(digitsCount(544));
        System.out.println(digitsCount(121317));
        System.out.println(digitsCount(0));
        System.out.println(digitsCount(12345));
        System.out.println(digitsCount(1289396387328L));

        System.out.println();
        System.out.println(totalPoints(new String[]{"cat", "create", "sat"}, "caster"));
        System.out.println(totalPoints(new String[]{"trance", "recant"}, "recant"));
        System.out.println(totalPoints(new String[]{"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed"));

        System.out.println();
        System.out.println(Arrays.deepToString(sumsUp(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.deepToString(sumsUp(new int[]{1, 2, 3, 7, 9})));
        System.out.println(Arrays.deepToString(sumsUp(new int[]{10, 9, 7, 2, 8})));
        System.out.println(Arrays.deepToString(sumsUp(new int[]{1, 6, 5, 4, 8, 2, 3, 7})));

        System.out.println();
        System.out.println(takeDownAverage(new String[]{"95%", "83%", "90%", "87%", "88%", "93%"}));
        System.out.println(takeDownAverage(new String[]{"10%"}));
        System.out.println(takeDownAverage(new String[]{"53%", "79%"}));

        System.out.println();
        System.out.println(caesarCipher("encode", "hello world", 3));
        System.out.println(caesarCipher("decode", "EPQSWX PEWX XEWO!", 4));

        System.out.println();
        System.out.println(setSetup(5, 3));
        System.out.println(setSetup(7, 3));

        System.out.println();
        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));

        System.out.println();
        System.out.println(isNew(3));
        System.out.println(isNew(30));
        System.out.println(isNew(321));
        System.out.println(isNew(123));
    }

    public static boolean sameLetterPattern(String first, String second) {
        String newFirst = stringToNumberSequence(first);
        String newSecond = stringToNumberSequence(second);

        return newFirst.equals(newSecond);
    }

    public static String stringToNumberSequence(String input) {
        ArrayList<Character> letters = new ArrayList<>();
        String numberSequence = "";

        for (int i = 0; i < input.length(); i++) {
            if (letters.contains(input.charAt(i))) {
                numberSequence += letters.indexOf(input.charAt(i));
            } else {
                letters.add(input.charAt(i));
                numberSequence += letters.indexOf(input.charAt(i));
            }
        }

        return numberSequence;
    }

    public static String spiderVsFly(String pos1, String pos2) {

        int spiderX = pos1.charAt(0) - 65;
        int spiderY = Integer.parseInt("" + pos1.charAt(1));

        int flyX = pos2.charAt(0) - 65;
        int flyY = Integer.parseInt("" + pos2.charAt(1));

        StringBuilder way = new StringBuilder();
        if (Math.abs(spiderX - flyX) > 2) {
            for (int i = spiderY; i > 0; i--) {
                way.append((char) (spiderX + 65)).append(i).append("-");
            }
            way.append("A0-");
            for (int i = 1; i <= flyY; i++) {
                way.append((char) (flyX + 65)).append(i).append("-");
            }
        } else {
            if (spiderY > flyY) {
                for (int i = spiderY; i >= flyY; i--) {
                    way.append((char) (spiderX + 65)).append(i).append("-");
                }
                for (int i = spiderX; i != flyX;) {
                    if (spiderX - flyX > 0) {
                        i--;
                    } else {
                        i++;
                    }
                    way.append((char) (i + 65)).append(flyY).append("-");
                }
            } else {
                for (int i = spiderX; i != flyX; ) {
                    way.append((char) (i + 65)).append(spiderY).append("-");
                    if (spiderX - flyX > 0) {
                        i--;
                    } else {
                        i++;
                    }
                }
                for (int i = spiderY; i <= flyY; i++) {
                    way.append((char) (flyY + 65)).append(i).append("-");
                }
            }
        }
        way.delete(way.length() - 1, way.length());
        return way.toString();
    }


    public static int digitsCount(long number) {

        int count = 1;
        if (number / 10 == 0) {
            return count;
        } else {
            count += digitsCount(number / 10);
        }

        return count;
    }

    public static int totalPoints(String[] array, String string) {
        int points = 0;
        for (String elem : array) {
            boolean flag = true;
            String newString = string;
            for (int i = 0; i < elem.length(); i++) {
                if (newString.contains("" + elem.charAt(i))) {
                    newString = newString.replaceAll("" + elem.charAt(i), "");
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                if (elem.length() == 6) {
                    points += 54;
                } else {
                    points += elem.length() - 2;
                }
            }
        }

        return points;
    }

    public static int[][] sumsUp(int[] array) {
        ArrayList<Integer> massive = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            massive.add(array[i]);
        }

        ArrayList<int[]> result = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] + array[i] == 8) {
                    int min = Math.min(array[i], array[j]);
                    int max = Math.max(array[i], array[j]);
                    result.add(new int[]{min, max});
                }
            }
        }

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.size() - 1; j++) {
                int[] current = result.get(j);
                int[] next = result.get(j + 1);
                int diffI = Math.abs(massive.indexOf(current[0]) - massive.indexOf(current[1]));
                int diffJ = Math.abs(massive.indexOf(next[0]) - massive.indexOf(next[1]));
                if (diffI > diffJ) {
                    result.set(j + 1, current);
                    result.set(j, next);
                } else if (diffI == diffJ) {
                    if (current[0] > next[0]) {
                        result.set(j + 1, current);
                        result.set(j, next);
                    }
                }
            }
        }

        return result.toArray(new int[result.size()][2]);
    }

    public static String takeDownAverage(String[] resultsString) {
        double sum = 0;
        double averageSum = 0;
        for (String result : resultsString) {
            sum += Integer.parseInt(result.substring(0, result.length() - 1));
        }
        averageSum = sum / resultsString.length;
        int addedResult = (int) Math.round((averageSum - 5) * (resultsString.length + 1) - sum);
        return addedResult + "%";
    }

    public static String caesarCipher(String mode, String string, int shift) {
        string = string.toUpperCase();
        String result = "";
        if (mode.equals("encode")) {
            for (char Char : string.toCharArray()) {
                int codeA = Char;
                if (codeA >= 65 && codeA <= 90) {
                    codeA -= 65;
                    codeA = (codeA + shift) % 26;
                    codeA += 65;
                    result += (char) codeA;
                } else {
                    result += Char;
                }
            }
        }
        if (mode.equals("decode")) {
            for (char Char : string.toCharArray()) {
                int codeA = Char;
                if (codeA >= 65 && codeA <= 90) {
                    codeA -= 90;
                    codeA = (codeA - shift) % 26;
                    codeA += 90;
                    result += (char) codeA;
                } else {
                    result += Char;
                }
            }
        }

        return result;
    }

    public static int setSetup(int n, int k) {
        if (k == 0) {
            return 1;
        }
        if (k > n) {
            return 0;
        }
        return n * setSetup(n - 1, k - 1);
    }

    public static String timeDifference(String cityA, String timestamp, String cityB) {

        HashMap<String, int[]> timeDiffCity = new HashMap<>();
        timeDiffCity.put("Los Angeles", new int[]{-8, 0});
        timeDiffCity.put("New York", new int[]{-5, 0});
        timeDiffCity.put("Caracas", new int[]{-4, 30});
        timeDiffCity.put("Buenos Aires", new int[]{-3, 0});
        timeDiffCity.put("London", new int[]{0, 0});
        timeDiffCity.put("Rome", new int[]{1, 0});
        timeDiffCity.put("Moscow", new int[]{3, 0});
        timeDiffCity.put("Tehran", new int[]{3, 30});
        timeDiffCity.put("New Delhi", new int[]{5, 30});
        timeDiffCity.put("Beijing", new int[]{8, 0});
        timeDiffCity.put("Canberra", new int[]{10, 0});

        HashMap<String, Integer> months = new HashMap<>();
        months.put("January", 1);
        months.put("February", 2);
        months.put("March", 3);
        months.put("April", 4);
        months.put("May", 5);
        months.put("June", 6);
        months.put("July", 7);
        months.put("August", 8);
        months.put("September", 9);
        months.put("October", 10);
        months.put("November", 11);
        months.put("December", 12);

        HashMap<String, Integer> daysMonths = new HashMap<>();
        daysMonths.put("January", 31);
        daysMonths.put("February", 28);
        daysMonths.put("March", 31);
        daysMonths.put("April", 30);
        daysMonths.put("May", 31);
        daysMonths.put("June", 30);
        daysMonths.put("July", 31);
        daysMonths.put("August", 31);
        daysMonths.put("September", 30);
        daysMonths.put("October", 31);
        daysMonths.put("November", 30);
        daysMonths.put("December", 31);

        String[] monthsArray = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};


        String[] time = timestamp.split(" ");
        time[1] = time[1].replaceAll(",", "");

        int[] timeA = timeDiffCity.get(cityA);
        int[] timeB = timeDiffCity.get(cityB);
        int[] cityDifference = new int[]{timeB[0] - timeA[0], timeB[1] - timeA[1]};

        String[] currentTimeA = time[3].split(":");
        int[] currentTime = {Integer.parseInt(currentTimeA[0]), Integer.parseInt(currentTimeA[1])};
        int[] newTime = new int[]{currentTime[0] + cityDifference[0], currentTime[1] + cityDifference[1]};

        int month = months.get(time[0]);
        int date = Integer.parseInt(time[1]);
        int year = Integer.parseInt(time[2]);

        if (newTime[1] < 0) {
            newTime[1] = 60 + newTime[1];
            newTime[0] -= 1;
            if (newTime[0] < 0) {
                newTime[0] = 24 - newTime[0];
                date -= 1;
                if (date == 0) {
                    month -= 1;
                    if (month >= 1) {
                        date = daysMonths.get(monthsArray[month - 1]);
                    } else {
                        year -= 1;
                        month = 12;
                        date = 31;
                    }
                }
            }
        }

        if (newTime[1] >= 60) {
            newTime[1] = newTime[1] % 60;
            newTime[0] += 1;
        }

        if (newTime[0] >= 24) {
            newTime[0] -= 24;
            date += 1;
            if (date > daysMonths.get(monthsArray[month - 1])) {
                month += 1;
                date = 1;
                if (month > 12) {
                    month = 1;
                    year += 1;
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        ans.append(year).append("-").append(month).append("-").append(date).append(" ");

        if (newTime[0] <= 9) {
            ans.append("0");
        }

        ans.append(newTime[0]).append(":");
        if (newTime[1] <= 9) {
            ans.append("0");
        }

        ans.append(newTime[1]);

        return ans.toString();
    }

    public static boolean isNew(int num) {
        ArrayList<Integer> digits = new ArrayList<>();
        int sameNum = num;
        while (num != 0) {
            digits.add(num % 10);
            num /= 10;
        }

        if (digits.size() > 1) {
            if (digits.size() == 2 && digits.contains(0)) {
                return true;
            } else {
                Collections.sort(digits);
            }
        } else {
            return true;
        }

        while (digits.get(0) == 0) {
            digits.add(0);
            digits.remove(0);
        }

        int i = 1;

        while (digits.get(digits.size() - 1) == 0) {
            digits.add(i, 0);
            digits.remove(digits.size() - 1);
            i += 1;
        }

        String minimalNum = "";
        while (!digits.isEmpty()) {
            minimalNum += digits.get(0);
            digits.remove(0);
        }

        return Integer.parseInt(minimalNum) == sameNum;
    }
}
