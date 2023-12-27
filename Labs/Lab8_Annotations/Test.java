package Labs.Lab8_Annotations;

import Labs.Lab8_Annotations.DataProccessors.CountryCount;
import Labs.Lab8_Annotations.DataProccessors.FilterByRussia;
import Labs.Lab8_Annotations.DataProccessors.TransformIntoLowerCase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите пути до файлов следующим образом");
        System.out.println("(путь до файла ввода) (путь до файла вывода)");
        String inputString = scanner.nextLine();
        String[] path = inputString.split(" ");

        System.out.println("Выберете операцию");
        System.out.println("Перевести в нижний кейс, Вывести пользователей из России, Вывести количество пользователей в стране");
        System.out.println("Чтобы закончить ввод, напишите end");
        String operation = scanner.nextLine().replaceAll(" ", "");
        ArrayList<String> operations = new ArrayList<>();
        while (!operation.equalsIgnoreCase("end")) {
            operations.add(operation);
            operation = scanner.nextLine().replaceAll(" ", "");
        }
        DataManager manager = new DataManager();
        manager.loadData(path[0]);
        for (String elem : operations) {
            if (elem.equalsIgnoreCase("перевестивнижнийкейс")) {
                manager.registerDataProcessor(new TransformIntoLowerCase());
            } else if (elem.equalsIgnoreCase("вывестипользователейизроссии")) {
                manager.registerDataProcessor(new FilterByRussia());
            } else if (elem.equalsIgnoreCase("вывестиколичествопользователейвстране")) {
                manager.registerDataProcessor(new CountryCount());
            } else {
                System.out.println("Такой операции нет:");
                System.out.println(elem);
            }

        }
        manager.processData();
        manager.saveData(path[1]);
        scanner.close();
    }
}
