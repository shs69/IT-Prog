package Labs.Lab5_RegularExpressions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;

public class HyperLink {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> text = new ArrayList<>();
        String string = scanner.nextLine();

        while (!string.isEmpty()) {
            text.add(toHyperLink(string));
            string = scanner.nextLine();
        }

        for (String elem: text){
//            FileOutputStream outputStream = new FileOutputStream("src/Labs/Lab5_RegularExpressions/1.html",true);
//            outputStream.write((elem + "\n").getBytes());
            System.out.println(elem);
        }
    }

    public static String toHyperLink(String text){

        Pattern pattern = Pattern.compile("\\b([\\w=-]{1,63}[./][\\w=-]{1,63})[^\\s@]*\\b");
        if (text.contains("https://")){
            text = text.replaceAll("https://", "");
        }
        if (text.contains("http://")) {
            text = text.replaceAll("http://", "");
        }
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String link = matcher.group();
            text = text.replaceAll(link,"<a href=https://" + link + ">https://" + link + "</a>");
        }
        
        return text;
    }
}
