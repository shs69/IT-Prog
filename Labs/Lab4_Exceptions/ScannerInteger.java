package Labs.Lab4_Exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerInteger {

    public static void main(String[] args){
        try {
            System.out.println(parseToInt());
        } catch (CustomInputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int parseToInt() throws InputMismatchException {
        try {
            return setDigit();
        } catch (InputMismatchException e) {
            throw new CustomInputMismatchException("ОПА НЕДЖАН!");
        }
    }

    private static int setDigit() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
