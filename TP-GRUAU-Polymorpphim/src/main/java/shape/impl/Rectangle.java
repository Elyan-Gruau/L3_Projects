package shape.impl;

import shape.ABSShape;
import svg.vector.IVecteur;
import svg.vector.Vecteur2D;
import svg.vector.Vector;

import java.awt.*;
import java.util.HashMap;

public class Rectangle extends Square {
    private double height;
    public Rectangle(IVecteur anchorPoint,double width,double height) {
        super(anchorPoint,width);
        this.height = height;
    }

    public Rectangle( HashMap<String, String> attributes) {
        this(new Vecteur2D(
                        Double.parseDouble(attributes.get("x")),
                        Double.parseDouble(attributes.get("y"))
                ),
                Double.parseDouble(attributes.get("width")),
                Double.parseDouble(attributes.get("height")));
    }

    @Override
    public double getSuperficy() {
        return 0;
    }

    @Override
    public double getPermimeter() {
        return 0;
    }

    @Override
    public void paint(Graphics g) {

    }

    public double getHeight() {
        return height;
    }
}
