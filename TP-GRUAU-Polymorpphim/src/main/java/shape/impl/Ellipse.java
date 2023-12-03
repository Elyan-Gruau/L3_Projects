package shape.impl;

import svg.vector.Vector;

public class Ellipse extends Circle{
    private double XRadius;
    public Ellipse(Vector centerPoint,double XRadius,double YRadius) {
        super(centerPoint,YRadius);
        this.XRadius = XRadius;
    }
}
