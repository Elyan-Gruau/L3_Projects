package svg.vecteur;

import java.util.ArrayList;


public class Vecteur2D  {

	private double x;
	private double y;
	
	
	public Vecteur2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}

	public double length() {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
	
	public Vecteur2D multK(double d) {
		return new Vecteur2D(this.x*d,this.y*d);
	}
	
	public Vecteur2D opposé() {
		return new Vecteur2D(-x,-y);
	}
	
	public static Vecteur2D add(Vecteur2D v1,Vecteur2D v2) {
		return new Vecteur2D(
				v1.getX()+v2.getX(),
				v1.getY()+v2.getY());
	}
	
	public static Vecteur2D add(ArrayList<Vecteur2D> vecteurs) {
		assert vecteurs != null && vecteurs.size()>=2;
		Vecteur2D resultat = vecteurs.get(0);
		for (int i=1; i<vecteurs.size(); i++) {
			resultat = add(resultat,vecteurs.get(i));
		}
		return resultat;
	}
	
	public static Vecteur2D sub(Vecteur2D v1, Vecteur2D v2) {
		return new Vecteur2D(
				v1.getX()-v2.getX(),
				v1.getY()-v2.getY());
	}
	
	public static double produitVectoriel(Vecteur2D v1,Vecteur2D v2) {
		return  v1.getX() * v2.getY() - v1.getY()* v2.getX();
	}

	public Vecteur2D transpose() {
		System.out.println(this.y+" ok "+this.x);
		return new Vecteur2D(this.y,this.x);
	}

	public static double produitScalaire(Vecteur2D v1, Vecteur2D v2) {
		return v1.getX() * v2.getX() + v1.getY() * v2.getY();
	}

	@Override
	public String toString() {
		return "<" + x + ", " + y + ">";
	}
}
