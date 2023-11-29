package shape.utils;

import shape.*;
import shape.exception.NoMatchingShapeConstructorException;
import shape.impl.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public enum ESVGShape implements ShapeClassProvider {
    CIRCLE(Circle.class),
    ELLIPSE(Ellipse.class),
    POLYGON(Polygon.class),
    SQUARE(Square.class),
    RECTANGLE(Rectangle.class);

    private final Class<?> shapeClass;

    ESVGShape(Class<?> shapeClass) {
        this.shapeClass = shapeClass;
    }


    public static ESVGShape getValueOf(String name){
        String upperName = name.toUpperCase();
        for (ESVGShape changeNameESVGShape : ESVGShape.values()){
            if(changeNameESVGShape.name().equals(upperName)){
                return changeNameESVGShape;
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
        //System.out.println("Parameter types: " + Arrays.toString(parameterTypes));

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

