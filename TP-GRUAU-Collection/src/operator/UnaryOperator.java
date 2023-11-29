package operator;

public enum UnaryOperator {
    FACTORIAL(UnaryOperator::factorial,"!"),
    NEGATIVE((int a) -> -a,"(-)"),
    SQUARE_ROOT((int a) -> Math.sqrt(a),"√"),
    ABSOLUTE(Math::abs,"|");

    private final String stringValue;

    private final String[] stringValuesAliases;
    private final FIUnaryOperation FIBinaryOperation;

    UnaryOperator(FIUnaryOperation o, String stringValue) {
        this(o, new String[] {stringValue});
    }

    UnaryOperator(FIUnaryOperation o, String ... stringsValues) {
        this.stringValue = stringsValues[0];
        this.FIBinaryOperation = o;

        int aliasesLength = stringsValues.length - 1;
        this.stringValuesAliases = new String[aliasesLength];
        for (int i = 0; i < aliasesLength; i++) {
            stringValuesAliases[i] = stringsValues[i + 1];
        }
    }

    private static int factorial(int n){
        if (n == 0)
            return 1;
        else
            return(n * factorial(n-1));
    }

}
