package shape.impl;

import svg.vector.IVecteur;
import svg.vector.Vecteur2D;
import svg.vector.Vector;

import java.util.HashMap;

public class Ellipse extends Circle{
    private double XRadius;
    public Ellipse(IVecteur centerPoint, double XRadius, double YRadius) {
        super(centerPoint,YRadius);
        this.XRadius = XRadius;

    }

    public Ellipse( HashMap<String, String> attributes) {
        this( new Vecteur2D(
                    Double.parseDouble("cx"),
                    Double.parseDouble("cy")
                ),
                Double.parseDouble("rx"),
                Double.parseDouble("ry"));
    }


    private static Object[] processAttributes( HashMap<String, String> attributes) {
        Vecteur2D centerPoint = new Vecteur2D(0,0);//TODO
        double YRadius = 30;
        return new Object[] {centerPoint,YRadius};
    }

    public double getXRadius() {
        return XRadius;
    }
}
