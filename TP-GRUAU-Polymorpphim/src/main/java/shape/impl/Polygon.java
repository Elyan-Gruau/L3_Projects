package shape.impl;

import shape.ABSShape;
import svg.vector.IVecteur;
import svg.vector.VecteurUtils;
import svg.vector.Vector;

import java.awt.*;
import java.util.HashMap;

public class Polygon extends ABSShape {

    protected IVecteur[] points;
    public Polygon(IVecteur[] points) {

    }


    public Polygon( HashMap<String, String> attributes) {
        double x = Double.parseDouble(attributes.get("x"));
        double y = Double.parseDouble(attributes.get("y"));
        IVecteur anchorPoint = VecteurUtils.fabriqueVecteur(x, y);
        for (String attribute : attributes.keySet()){
            System.out.println(attribute+": "+attributes.get(attribute));
        }
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
