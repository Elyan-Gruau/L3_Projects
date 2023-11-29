package operator;

import exception.UnknownOperatorException;

import java.util.ArrayList;

public enum BinaryOperator {

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
    private final FIBinaryOperation FIBinaryOperation;

    BinaryOperator(FIBinaryOperation o, char charValue) {
      this(o, new char[] {charValue});
    }

    BinaryOperator(FIBinaryOperation o, char ... charValues) {
        this.charValue = charValues[0];
        this.FIBinaryOperation = o;

        int aliasesLength = charValues.length-1;
        this.charValuesAliases = new char[aliasesLength];
        for( int i = 0; i < aliasesLength; i++ ){
            charValuesAliases[i] = charValues[i+1];
        }
    }


    public char[] getCharValuesAliases() {
        return charValuesAliases;
    }

    public static BinaryOperator valueOf(char c) {
        for (BinaryOperator binaryOperator : BinaryOperator.values()) {
            if (binaryOperator.getCharValue() == c){
                return binaryOperator;
            }else if (binaryOperator.hasAliases()){
                for (char alias : binaryOperator.getCharValuesAliases()){
                    if (alias == c){
                        return binaryOperator;
                    }
                }
            }
        }
        throw new UnknownOperatorException(c);
    }

    public static char[] getAllOperators(){
        ArrayList<Character> operatorList = new ArrayList<>();
        for (BinaryOperator binaryOperator : BinaryOperator.values()){
            operatorList.add(binaryOperator.getCharValue());
            for (char value : binaryOperator.getCharValuesAliases()){
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
        return FIBinaryOperation.operate(a,b);
    }

    public char getCharValue() {
        return charValue;
    }

    public boolean hasAliases(){
        return charValuesAliases.length > 0;
    }


}
