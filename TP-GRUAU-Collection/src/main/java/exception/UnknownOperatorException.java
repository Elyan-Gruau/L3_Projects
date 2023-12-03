package main.java.exception;

public class UnknownOperatorException extends RuntimeException {

    public UnknownOperatorException(char expression) {
        super("Unknown main.java.operator: "+expression);
    }
}
