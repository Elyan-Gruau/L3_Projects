package shape.impl;

import shape.ABSShape;
import svg.vector.IVecteur;
import svg.vector.Vecteur2D;

import java.awt.*;
import java.util.HashMap;

public class Square extends ABSShape {
    protected double width;
    public Square(IVecteur anchorPoint, double width) {
        this.anchorPoint = anchorPoint;
        this.width = width;
    }

    public Square( HashMap<String, String> attributes) {
        this(new Vecteur2D(
                    Double.parseDouble(attributes.get("x")),
                    Double.parseDouble(attributes.get("y"))
                ),
                Double.parseDouble(attributes.get("width")));
    }

    @Override
    public double getSuperficy() {
        return width * width;
    }

    @Override
    public double getPermimeter() {
        return  width * 4;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public void paint(Graphics g) {

    }

    @Override
    public String toString() {
        return "Square{" +
                "width=" + width +
                ", anchorPoint=" + anchorPoint +
                '}';
    }
}
