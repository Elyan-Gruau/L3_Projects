package svg.polygone.view;

import java.awt.Graphics;

import svg.polygone.model.PolygoneOld;
import svg.polygone.model.PolygoneIterable;
import svg.vector.IVecteur;

public class DessinePolygone {
	private static int[] xPoints, yPoints;
	private static void buildPolygone(PolygoneOld p) {
		xPoints = new int[p.numberOfPoints()];
		yPoints = new int[p.numberOfPoints()];
		int i = 0;
		for (IVecteur v : new PolygoneIterable(p)) {
			xPoints[i] = (int)v.get(0);
			yPoints[i] = (int)v.get(1);
			i++;
		}
	}
	public static void drawPolygone(Graphics g, PolygoneOld p) {
		buildPolygone(p);
		g.setColor(p.getStokeColor());
		g.drawPolygon(xPoints, yPoints, xPoints.length);
	}
	public static void fillPolygone(Graphics g, PolygoneOld p) {
		buildPolygone(p);
		g.setColor(p.getFillColor());
		g.fillPolygon(xPoints, yPoints, xPoints.length);
	}
	
	@Deprecated
	public static void toDelete(String[] args) {
		//Polygone poly = RegularPolygonBuilder.mkRegularPolygon(10, 50);
		//Color[] c = {Color.blue, Color.red, Color.green, Color.pink};
		//Polygone[] t=poly.triangulation();

		//new FrameHelper(350, 250, true).draw(g -> {
			//drawPolygone(g, poly, Color.black);
			//for (int i = 0; i < t.length; i++)
				//fillPolygone(g, t[i], c[i%c.length]);
		//});
	}
}
