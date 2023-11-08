package Labs.Lab4_Exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerInteger {

    public static void main(String[] args){
        try {
            System.out.println(setDigit());
        } catch (CustomInputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int setDigit() {
        try (Scanner scanner = new Scanner(System.in)) {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new CustomInputMismatchException("Данные введённые вами не являются целым числом. \nВведите пожалуйста ЦЕЛОЕ число");
        }

    }
}
