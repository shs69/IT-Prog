package Labs.Lab5_RegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckPassword {
    public static void main(String[] args) {
        System.out.println(checkPassword("234590U43"));
    }
    public static String checkPassword(String password) {
        String result = "";
        Pattern pattern = Pattern.compile("(?=.*[A-Z])");
        Matcher matcher = pattern.matcher(password);
        if (!matcher.find()) {
            result = "Please enter the uppercase letters";
            return result;
        }
        pattern = Pattern.compile("(?=.*[a-z])");
        matcher = pattern.matcher(password);
        if (!matcher.find()){
            result = "Please enter the lowercase letters";
            return result;
        }
        pattern = Pattern.compile("[?=.\\d]");
        matcher = pattern.matcher(password);
        if (!matcher.find()) {
            result = "Please enter the digits";
            return result;
        }

        pattern = Pattern.compile("^.{0,7}$");
        matcher = pattern.matcher(password);
        if (matcher.find()) {
            result = "Too short password";
            return result;
        }

        pattern = Pattern.compile("^.{17,1000000}$");
        matcher = pattern.matcher(password);
        if (matcher.find()) {
            result = "Too long password";
            return result;
        }

        pattern = Pattern.compile("^[A-Za-z\\d]{8,16}$");
        matcher = pattern.matcher(password);
        if (!matcher.find()) {
            result = "Remove other symbols";
            return result;
        }

        result = "Correct password";
        return result;
    }
}
