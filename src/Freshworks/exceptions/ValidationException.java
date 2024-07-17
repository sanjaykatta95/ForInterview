package Freshworks.exceptions;

public class ValidationException extends RuntimeException{
    public ValidationException(String msg){
        throw new RuntimeException(msg);
    }
}
