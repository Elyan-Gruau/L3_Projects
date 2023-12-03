package svg.vector;

import java.util.ArrayList;


public class Vecteur2D  implements IVecteur{

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

	@Override
	public double length() {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}

	@Override
	public Vecteur2D multK(double d) {
		return new Vecteur2D(this.x*d,this.y*d);
	}

	@Override
	public Vecteur2D opposé() {
		return new Vecteur2D(-x,-y);
	}

	


	public Vecteur2D transpose() {
		return new Vecteur2D(this.y,this.x);
	}


	@Override
	public String toString() {
		return "<" + x + ", " + y + ">";
	}

	@Override
	public int dimension() {
		return 2;
	}

	public double get(int n){
		return switch (n) {
			case 0 -> getX();
			case 1 -> getY();
			default -> Double.NaN;
		};
	}
}
