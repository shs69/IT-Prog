package Labs.Lab4_Exceptions;

import java.util.InputMismatchException;

public class CustomInputMismatchException extends InputMismatchException {
    public CustomInputMismatchException() {
        super("Custom Input Mismatch Exception");
    }

    public CustomInputMismatchException(String message){
        super(message);
    }
}
