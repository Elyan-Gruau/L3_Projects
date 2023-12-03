package main.java;

import main.java.exception.IllegalExpressionException;
import main.java.exception.UnknownOperatorException;
import main.java.operator.BinaryOperator;

import java.util.ArrayDeque;

public class InvertedPolishCalculator {

    private static final char[] unaryOperators = {'?'};//todo
    private static final char[] binaryOperators = BinaryOperator.getAllOperators();
    public static int evaluate(String expression){
        return evaluate(expression.split(" "));
    }
    public static int evaluate(String[] expression){
        ArrayDeque<Integer> pile = new ArrayDeque<>();
        for (String element : expression){
            if (element.isBlank()) continue;
            try{
                pile.push(Integer.parseInt(element));
            }catch (NumberFormatException e){
                if (isBinary(element)){
                    int a = pile.pop();int b = pile.pop();

                    BinaryOperator binaryOperator = BinaryOperator.valueOf(element.charAt(0));
                    pile.push(binaryOperator.operate(b,a));
                }
                else if (isUnary(element)){
                    int value = pile.pop();
                    pile.push(value); //todo ??
                }else{
                    throw new UnknownOperatorException(element.charAt(0));
                }
            }
        }
        if (pile.size() == 1) return pile.pop();
        throw new IllegalExpressionException(expression);
    }


    public static boolean isUnary(String expression){
        assert expression.length() == 1;
        for(char c : unaryOperators){
            if (c == (expression.charAt(0))){
                return true;
            }
        }
        return false;
    }

    public static boolean isBinary(String expression){
        assert expression.length() == 1;
        for(char c : binaryOperators){
            if (c == (expression.charAt(0))){
                return true;
            }
        }
        return false;
    }

}
