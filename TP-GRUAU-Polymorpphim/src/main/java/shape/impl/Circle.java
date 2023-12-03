package shape.impl;

import shape.ABSShape;
import svg.vector.IVecteur;
import svg.vector.Vecteur2D;

import java.awt.*;
import java.util.HashMap;

public class Circle extends ABSShape {
    protected double radius;

    public Circle(IVecteur centerPoint, Double radius) {
        this.anchorPoint = centerPoint;
        this.radius = radius;
    }

    public Circle( HashMap<String, String> attributes){
        this( new Vecteur2D(
                    Double.parseDouble(attributes.get("cx")),
                    Double.parseDouble(attributes.get("cy"))
                ),
                Double.parseDouble(attributes.get("r")));
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

    public double getRadius() {
        return radius;
    }
}
