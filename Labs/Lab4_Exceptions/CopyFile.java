package Labs.Lab4_Exceptions;

import java.io.*;
import java.nio.channels.WritePendingException;
import java.nio.charset.StandardCharsets;

public class CopyFile {
    public static void main(String[] args) throws IOException {

        final boolean result = copyFile("src/Labs/Lab4_Exceptions/test.txt", "src/Labs/Lab4_Exceptions/copy_test.txt" );
        System.out.println(result);

    }

    private static boolean copyFile(String pathToFile1, String pathToFile2) throws IOException{
        String result = "";

        try (InputStreamReader input = new InputStreamReader(new FileInputStream(pathToFile1), StandardCharsets.UTF_8)){
            int line;
            while ((line = input.read()) != -1) {
                result += (char) line;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
            return false;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }

        try (FileOutputStream outputStream = new FileOutputStream(pathToFile2)) {
            outputStream.write(result.getBytes());
        } catch (WritePendingException | WriteAbortedException e) {
            System.out.println("Ошибка записи");
            return false;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
