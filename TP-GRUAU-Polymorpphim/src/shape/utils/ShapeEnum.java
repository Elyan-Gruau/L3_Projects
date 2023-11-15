package shape.utils;

import shape.*;
import shape.exception.NoMatchingShapeConstructorException;
import shape.impl.Circle;
import shape.impl.Ellipse;
import shape.impl.Polygon;
import shape.impl.Square;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public enum ShapeEnum implements ShapeClassProvider {
    CIRCLE(Circle.class),
    ELLIPSE(Ellipse.class),
    POLYGON(Polygon.class),
    SQUARE(Square.class);

    private final Class<?> shapeClass;

    ShapeEnum(Class<?> shapeClass) {
        this.shapeClass = shapeClass;
    }


    public static ShapeEnum getValueOf(String name){
        String upperName = name.toUpperCase();
        for (ShapeEnum changeNameShapeEnum : ShapeEnum.values()){
            if(changeNameShapeEnum.name().equals(upperName)){
                return changeNameShapeEnum;
            }
        }
        return null;
    }

    @Override
    public Class<?> getShapeClass() {
        return shapeClass;
    }

    public IShape createShapeInstance(Object... args) throws IllegalAccessException, InstantiationException, NoMatchingShapeConstructorException {
        //Obtiens la liste des classes des paramètres en utilisant un stream basé sur les args.
        Class<?>[] parameterTypes = Arrays.stream(args).map(Object::getClass).toArray(Class[]::new);
        System.out.println("Parameter types: " + Arrays.toString(parameterTypes));

        try {
            //Trouve le constructeur en se basant sur la classe et sur la signature du constructeur.
            Constructor<?> constructor = shapeClass.getDeclaredConstructor(parameterTypes);

            //Use the previous constructor to create a new instance
            return (IShape) constructor.newInstance(args);
        } catch (InvocationTargetException e ) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e){
            throw new NoMatchingShapeConstructorException(shapeClass,parameterTypes);
        }
    }
}

