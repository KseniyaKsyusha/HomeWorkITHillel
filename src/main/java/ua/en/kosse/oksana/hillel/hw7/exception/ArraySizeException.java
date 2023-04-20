package ua.en.kosse.oksana.hillel.hw7.exception;

public class ArraySizeException extends Exception {
    private int number;
    public int getNumber(){return number;}
    public ArraySizeException(String message, int num){
        super(message);
        number=num;
    }
}
