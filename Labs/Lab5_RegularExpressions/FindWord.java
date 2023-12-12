package Labs.Lab5_RegularExpressions;
import java.util.regex.*;

public class FindWord {
    public static void main(String[] args) {
        String result = wordSearch('o', "aaaaa AAAAA abu bandit mama papa dasdad ");
        if (result.isEmpty()) {
            System.out.println("В строке нет слов начинающихся с этой буквы");
        } else {
            System.out.println(result);
        }
    }

    public static String wordSearch(char letter, String string) {
        String result = "";
        String newLetter = "" + letter;
        String regularExpression = "\\b[" + newLetter.toLowerCase() + newLetter.toUpperCase() + "][A-Za-z]*\\b";
        Pattern pattern = Pattern.compile(regularExpression);
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            result += matcher.group() + "\n";
        }

        return result;
    }
}
