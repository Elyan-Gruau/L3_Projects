package shape.impl;

import svg.vector.IVecteur;
import svg.vector.Vecteur2D;

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
        return height * width;
    }

    @Override
    public double getPermimeter() {
        return height * 2 + width * 2;
    }

    @Override
    public void paint(Graphics g) {

    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "height=" + height +
                ", width=" + width +
                ", anchorPoint=" + anchorPoint +
                '}';
    }
}
