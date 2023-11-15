package shape.impl;

import shape.ABSShape;
import svg.vecteur.Vector;

import java.awt.*;

public class Circle extends ABSShape {
    protected double radius;

    public Circle(Vector centerPoint,Double radius) {
        super(new Vector[]{centerPoint}, centerPoint );
        this.radius = radius;
    }

//    public Circle(Object... args){
//        this((Vector) args[0],(double) args[1]);
//
//    }

    @Override
    public double getSuperficy() {
        return 12;//todo
    }

    @Override
    public double getPermimeter() {
        return 0;//todo
    }

    @Override
    public void paint(Graphics g) {

    }
}
