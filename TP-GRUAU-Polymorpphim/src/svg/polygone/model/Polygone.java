package svg.polygone.model;

import java.awt.Color;
import java.awt.Graphics;

import svg.balise.Balise;
import svg.balise.EBaliseType;
import svg.vecteur.Vector;

public class Polygone {
	private Vector[] points ;
	private Color fillColor;
	private Color strokeColor;
	private int strokeWidth;
	
	
	public Polygone(Vector... points) {
		this.points = points.clone();
	}

	public double perimetre() {
		double perimetre = Vector.sub(points[0], points[points.length-1]).length();
		for (int i=0; i<points.length-1; i++) {
			perimetre += Vector.sub(points[i], points[i+1]).length();
		}
	
		return perimetre;
		
	}
	
	
	public Polygone(Balise balise) {
		assert balise != null: "la balise ne doit pas être null.";
		assert balise.getType() == EBaliseType.polygon : "La balise donnée n'est pas de type polygon.";
		String pointsAsText = balise.getAttribute("points");
		if (pointsAsText != null) {
			String[] splittedPoints = pointsAsText.split(" ");
			Vector[] tempPoints = new Vector[splittedPoints.length];
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
				tempPoints[i] = new Vector(x,y);
			}
			
			//Compter les occurences nulles 
			this.points = new Vector[splittedPoints.length-nullVectors];
			int j = 0;
			for (int i = 0 ; i<tempPoints.length; i++  ) {
				if (tempPoints[i] != null) {
					points[j] = tempPoints[i];
					j++;
				}
			}
		}
	
		
		
		//todo getcolors
		
	}
	
	public Color getStokeColor() {
		return this.strokeColor;
	}
	
	public int getStokeWidth() {
		return this.strokeWidth;
	}
	
	public Color getFillColor() {
		return this.fillColor;
	}
	

	public Vector barycentre() {
		Vector res = Vector.add(points);
		return res.multK(1.0/numberOfPoints());
	
	}
	
	public double distanceAuCentre() {
		//Cela marche avec v1, v2, v3, ici j'ai pris v2 car le barycentre est équidistant de tout ses sommets.
		return (Vector.sub(barycentre(), points[0])).length();
	}

	public Vector getPoint(int i) {
		return points[i];
	}

	public int numberOfPoints() {
		return points.length;
	}
	
	public void draw(Graphics g) {
		
	}
	
	public Vector get(int i) {
		return points[i];
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Vector vecteur:points) {
			sb.append(vecteur.toString());
			sb.append(" ");
		}
		return sb.toString();
	}
	
}
