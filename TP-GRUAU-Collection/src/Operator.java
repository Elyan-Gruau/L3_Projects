import exception.UnknownOperatorException;

import java.util.ArrayList;

public enum Operator {

    multiply((int a, int b ) -> a * b,
            '*','x'),
    divide((int a, int b ) -> a / b,
            '/','\\'),
    subtract((int a, int b ) -> a - b,
            '-'),
    add((int a, int b ) -> a + b,
            '+'),
    modulo((int a, int b ) -> a % b,
            '%');

    private final char charValue;
    private final char[] charValuesAliases;
    private final Operation operation;


    Operator( Operation o, char charValue) {
      this(o, new char[] {charValue});
    }

    Operator(Operation o, char ... charValues) {
        this.charValue = charValues[0];
        this.operation = o;

        int aliasesLength = charValues.length-1;
        this.charValuesAliases = new char[aliasesLength];
        for( int i = 0; i < aliasesLength; i++ ){
            charValuesAliases[i] = charValues[i+1];
        }
    }


    public char[] getCharValuesAliases() {
        return charValuesAliases;
    }

    public static Operator valueOf(char c) {
        for (Operator operator: Operator.values()) {
            if (operator.getCharValue() == c){
                return operator;
            }else if (operator.hasAliases()){
                for (char alias : operator.getCharValuesAliases()){
                    if (alias == c){
                        return operator;
                    }
                }
            }
        }
        throw new UnknownOperatorException(c);
    }

    public static char[] getAllOperators(){
        ArrayList<Character> operatorList = new ArrayList<>();
        for (Operator operator: Operator.values()){
            operatorList.add(operator.getCharValue());
            for (char value : operator.getCharValuesAliases()){
                operatorList.add(value);
            }
        }
        char[] result = new char[operatorList.size()];
        for (int i = 0; i < operatorList.size(); i++) {
            result[i] = operatorList.get(i);
        }
        return result ;
    }

    public int operate(int a, int b) {
        return operation.operate(a,b);
    }

    public char getCharValue() {
        return charValue;
    }

    public boolean hasAliases(){
        return charValuesAliases.length > 0;
    }

    private interface Operation {
        int operate(int a, int b);
    }
}
