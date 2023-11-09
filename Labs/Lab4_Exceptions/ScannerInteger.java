package Labs.Lab4_Exceptions;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerInteger {

    public static void main(String[] args){
        try {
            System.out.println(setDigit());
        } catch (CustomInputMismatchException e) {
            System.out.println(e.getMessage());
            try (FileOutputStream outputStream = new FileOutputStream("src/Labs/Lab4_Exceptions/error.txt", true)) {
                outputStream.write((e.getMessage() + "\n").getBytes());
            } catch (IOException e1) {
                System.out.println(e1.getMessage());
            }
        }
    }

    private static int setDigit() throws CustomInputMismatchException {
        try (Scanner scanner = new Scanner(System.in)) {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new CustomInputMismatchException();
        }
    }
}
