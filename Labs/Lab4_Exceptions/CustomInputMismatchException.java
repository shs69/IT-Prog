package Labs.Lab4_Exceptions;

public class CustomInputMismatchException extends Exception {
    public CustomInputMismatchException() {
        super("Custom Input Mismatch Exception");
    }

    public CustomInputMismatchException(String message){
        super(message);
    }
}
