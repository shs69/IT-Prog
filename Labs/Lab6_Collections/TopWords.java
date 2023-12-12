package Labs.Lab6_Collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        String filePath = "src/Labs/Lab6_Collections/text.txt";
        File file = new File(filePath);
        Scanner scanner;
        Map<String, Integer> countOfWords = new HashMap<>();
        try {
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase();
                if (countOfWords.containsKey(word)) {
                    int count = countOfWords.get(word);
                    countOfWords.put(word, count + 1);
                } else {
                    countOfWords.put(word, 1);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка чтения файла");;
        }

        List<Map.Entry<String, Integer>> countOfWordsList = new ArrayList<>(countOfWords.entrySet());
        countOfWordsList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        for (int i = 0; i < 10 && i < countOfWords.size(); i++) {
            String word = countOfWordsList.get(i).getKey();
            int count = countOfWordsList.get(i).getValue();
            System.out.println(word + ":" + count);
        }

    }
}
