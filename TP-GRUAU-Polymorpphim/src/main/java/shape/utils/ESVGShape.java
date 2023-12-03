package shape.utils;

import shape.exception.NoMatchingShapeConstructorException;
import shape.exception.NoMatchingShapeException;
import shape.*;
import shape.impl.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public enum ESVGShape implements ShapeClassProvider {
    CIRCLE(Circle.class,"circle"),
    ELLIPSE(Ellipse.class,"ellipse"),
    POLYGON(Polygon.class,"polygon"),
    SQUARE(Square.class,"square"),
    RECTANGLE(Rectangle.class,"rect"),;

    private final Class<?> shapeClass;
    private final String name;

    ESVGShape(Class<?> shapeClass,String name) {
        this.shapeClass = shapeClass;
        this.name = name;
    }


    public static ESVGShape getValueOf(String name) throws NoMatchingShapeException {
        String lowerName = name.toLowerCase();
        for (ESVGShape ESVGShape : ESVGShape.values()){
            if(ESVGShape.getName().equals(lowerName)){
                return ESVGShape;
            }
        }
        throw new NoMatchingShapeException(name);
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

    public String getName() {
        return name;
    }

}

