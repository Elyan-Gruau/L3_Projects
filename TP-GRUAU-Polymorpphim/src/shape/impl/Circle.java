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


    @Override
    public double getSuperficy() {
        return Math.PI*(Math.pow(radius,2));
    }

    @Override
    public double getPermimeter() {
        return  2 * Math.PI * radius;
    }

    @Override
    public void paint(Graphics g) {

    }
}
