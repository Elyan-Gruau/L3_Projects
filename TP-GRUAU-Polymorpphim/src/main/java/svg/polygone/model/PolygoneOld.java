package svg.polygone.model;

import java.awt.Color;
import java.awt.Graphics;

import svg.tag.Tag;
import svg.tag.ETagType;
import svg.vector.IVecteur;
import svg.vector.VecteurUtils;
import svg.vector.Vecteur;

@Deprecated
public class PolygoneOld {
	private IVecteur[] points ;
	private Color fillColor;
	private Color strokeColor;
	private int strokeWidth;
	
	
	public PolygoneOld(IVecteur... points) {
		this.points = points.clone();
	}

	public double perimetre() {
		double perimetre = VecteurUtils.sub(points[0], points[points.length-1]).length();
		for (int i=0; i<points.length-1; i++) {
			perimetre += VecteurUtils.sub(points[i], points[i+1]).length();
		}
	
		return perimetre;
		
	}
	
	
	public PolygoneOld(Tag tag) {
		assert tag != null: "la balise ne doit pas être null.";
		assert tag.getType() == ETagType.polygon : "La balise donnée n'est pas de type polygon.";
		String pointsAsText = tag.getAttribute("points");
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
	

	public IVecteur barycentre() {
		IVecteur res = VecteurUtils.add(points);
		return res.multK(1.0/numberOfPoints());
	
	}
	
	public double distanceAuCentre() {
		//Cela marche avec v1, v2, v3, ici j'ai pris v2 car le barycentre est équidistant de tout ses sommets.
		return (VecteurUtils.sub(barycentre(), points[0])).length();
	}

	public IVecteur getPoint(int i) {
		return points[i];
	}

	public int numberOfPoints() {
		return points.length;
	}
	
	public void draw(Graphics g) {
		
	}
	
	public IVecteur get(int i) {
		return points[i];
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (IVecteur vecteur:points) {
			sb.append(vecteur.toString());
			sb.append(" ");
		}
		return sb.toString();
	}
	
}
