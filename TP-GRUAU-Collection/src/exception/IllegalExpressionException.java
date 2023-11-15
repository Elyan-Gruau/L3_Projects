package exception;

public class IllegalExpressionException extends RuntimeException {

    public IllegalExpressionException(String[] expression) {
        super("Invalid expression : "+String.join(" ",expression));
    }
}
