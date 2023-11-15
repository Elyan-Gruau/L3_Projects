package shape.impl;

import shape.ABSShape;
import svg.vecteur.Vector;

import java.awt.*;

public class Square extends ABSShape {
    public Square(Vector[] points) {
        super(points,points[0]);
        assert points.length == 4;
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
