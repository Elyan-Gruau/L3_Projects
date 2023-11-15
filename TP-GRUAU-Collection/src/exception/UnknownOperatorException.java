package exception;

public class UnknownOperatorException extends RuntimeException {

    public UnknownOperatorException(char expression) {
        super("Unknown operator: "+expression);
    }
}
