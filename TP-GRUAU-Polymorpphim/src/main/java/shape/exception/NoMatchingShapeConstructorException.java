package shape.exception;

import java.util.Arrays;

public class NoMatchingShapeConstructorException extends Exception {

    public NoMatchingShapeConstructorException(Class<?> c,Class<?>[] parameterTypes) {
        super("\n "+c.getName()+" doesn't have a constructor with the following signature :"+ Arrays.toString(parameterTypes));
    }
}
