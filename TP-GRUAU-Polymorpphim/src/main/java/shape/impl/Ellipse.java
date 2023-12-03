package shape.impl;

import svg.vector.IVecteur;
import svg.vector.Vecteur2D;

import java.util.HashMap;

public class Ellipse extends Circle{
    private double XRadius;
    public Ellipse(IVecteur centerPoint, double XRadius, double YRadius) {
        super(centerPoint,YRadius);
        this.XRadius = XRadius;

    }

    public Ellipse( HashMap<String, String> attributes) {
        this( new Vecteur2D(
                    Double.parseDouble(attributes.get("cx")),
                    Double.parseDouble(attributes.get("cy"))
                ),
                Double.parseDouble(attributes.get("rx")),
                Double.parseDouble(attributes.get("ry")));
        System.out.println("OKK");
    }

    @Override
    public double getSuperficy() {
        return Math.PI * radius * XRadius;
    }

    @Override
    public double getPermimeter() {
        //Si a = b alors l'ellipse est un cercle.
        return 2 * Math.PI * Math.sqrt(
                (Math.pow(radius, 2) + Math.pow(XRadius, 2)) /2
        );
    }

    public double getXRadius() {
        return XRadius;
    }

    @Override
    public String toString() {
        return "Ellipse{" +
                "XRadius=" + XRadius +
                ", radius=" + radius +
                ", anchorPoint=" + anchorPoint +
                '}';
    }
}
