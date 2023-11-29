package shape.impl;

import shape.ABSShape;
import svg.vector.Vector;

import java.awt.*;

public class Polygon extends ABSShape {
    public Polygon(Vector[] points) {
        super(points,points[0]);
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
}
