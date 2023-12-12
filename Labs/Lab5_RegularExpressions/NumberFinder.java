package Labs.Lab5_RegularExpressions;

import java.util.ArrayList;
import java.util.regex.*;

public class NumberFinder {

    public static void main(String[] args) {
        System.out.println(findNumbers("The 42.4237462367482 price of 23434.33 the product is $-19.99"));
    }

    public static String findNumbers(String string) {
        Pattern pattern = Pattern.compile("-?\\d+[.]?\\d+");
        Matcher matcher = pattern.matcher(string);
        ArrayList<Double> digits = new ArrayList<>();

        while (matcher.find()) {
            try {
                digits.add(Double.parseDouble(matcher.group()));
            } catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }

        return digits.toString();
    }
}
