package shape.impl;

import shape.ABSShape;
import svg.vector.IVecteur;
import svg.vector.VecteurUtils;
import svg.vector.Vecteur;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;

public class Polygon extends ABSShape {

    protected IVecteur[] points;
    public Polygon(IVecteur[] points) {
        this.points = points;
        this.anchorPoint = points[0];
    }


    public Polygon( HashMap<String, String> attributes) {
        String pointsAsText = attributes.get("points");
        if (pointsAsText != null) {
            String[] splittedPoints = pointsAsText.split(" ");
            Vecteur[] tempPoints = new Vecteur[splittedPoints.length];
            int nullVectors = 0;
            for (int i = 0 ; i< splittedPoints.length;i++) {
                if (splittedPoints[i].isEmpty()) {
                    nullVectors ++;
                    continue;
                }

                String[] coordinates = splittedPoints[i].split(",");
                //System.out.println(coordinates[0]+" : "+coordinates[1]);
                double x = Double.parseDouble(coordinates[0]);
                double y = Double.parseDouble(coordinates[1]);
                //System.out.println("CREER ");
                tempPoints[i] = new Vecteur(x,y);
            }

            //Compter les occurences nulles
            this.points = new Vecteur[splittedPoints.length-nullVectors];
            int j = 0;
            for (int i = 0 ; i<tempPoints.length; i++  ) {
                if (tempPoints[i] != null) {
                    points[j] = tempPoints[i];
                    j++;
                }
            }
        }
        assert points != null;
        if (points.length>0) {
            this.anchorPoint = points[0];
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

    public IVecteur barycentre() {
        IVecteur res = VecteurUtils.add(points);
        return res.multK(1.0/numberOfPoints());

    }

    public int numberOfPoints() {
        return points.length;
    }

    public double distanceAuCentre() {
        //Cela marche avec v1, v2, v3, ici j'ai pris v2 car le barycentre est équidistant de tout ses sommets.
        return (VecteurUtils.sub(barycentre(), points[0])).length();
    }

    @Override
    public void paint(Graphics g) {

    }

    public IVecteur get(int i) {
        return points[i];
    }

    @Override
    public String toString() {
        return "Polygon{" +
                "points=" + Arrays.toString(points) +
                ", anchorPoint=" + anchorPoint +
                '}';
    }
}
