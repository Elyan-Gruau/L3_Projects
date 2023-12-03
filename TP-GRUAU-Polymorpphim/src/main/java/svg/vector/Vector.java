package svg.vector;


public class Vector {
	private double[] dimensions;
	
	//	une méthode pour construire un autre vecteur colinéaires mais k fois plus long, où k est un paramètre
		//une méthode qui prend 2 vecteurs de dimension 3 et construit leur produit vectoriel, on pourra pour cela s'aider du produit en croix de dimension 2
	
	
	public Vector(int nbDim, double[] values) {
		this.dimensions = new double[nbDim];
		if (values.length > 0) {
			for (int i=0; i<nbDim; i++) {
				if (i>=values.length) {
					dimensions[i] = 0.0;
				}else {
					dimensions[i] = values[i];	
				}
				
			}
		}

	}
	
	public Vector(double... values) {
		this.dimensions = values;
	}
	

	public int dimension() {
		return dimensions.length;
	}
	
	public double length() {
		double result = 0.0;
		for (double dim: dimensions) {
			result+=Math.pow(dim, 2);
		}
		return Math.sqrt(result);
	}
	
	public Vector transpose() {
		assert dimension() == 2;
		double[] transp = {this.get(1),this.get(0)};
		return new Vector(  transp);
	}
	
	
	public static Vector add(Vector... vecteurs) {
		assert vecteurs !=  null && vecteurs.length >= 2;
		
		int requiredDim = vecteurs[0].dimension();
		for (int i=1;i<vecteurs.length;i++) {
			assert requiredDim == vecteurs[i].dimension() : "Les vecteurs ne sont pas de la même dimension.";
		}
		
		
		Vector result =  vecteurs[0];
		for (int i=1;i<vecteurs.length; i++) {
			result = Vector.add(result, vecteurs[i]);
		}
		return result;
	}
	
	//une méthode qui prend n vecteurs de même dimension et construit leur somme
	public static Vector add(Vector v0, Vector v1) {
		assert sameDimension() : "Les vecteurs ne sont pas de la même dimension" ;
		assert v0.dimension() == v1.dimension();
		double[] resultValues = new double[v0.dimension()];
	
		for (int i=0; i<v0.dimension() ;i++) {
			resultValues[i] = v0.get(i) + v1.get(i) ;
		}
		return new Vector(resultValues);
	}
	
	public static Vector sub(Vector v0, Vector v1) {
		assert sameDimension() : "Les vecteurs ne sont pas de la même dimension" ;
		assert v0.dimension() == v1.dimension();
		double[] resultValues = new double[v0.dimension()];
	
		for (int i=0; i<v0.dimension() ;i++) {
			resultValues[i] = v0.get(i) - v1.get(i) ;
		}
		return new Vector(resultValues);
	}
	
	//une méthode qui prend n vecteurs de même dimension et construit leur différence
	public static Vector sub(Vector v0, Vector v1, Vector... vecteurs) {
		Vector result =  Vector.sub(v0, v1);
		assert vecteurs !=  null && vecteurs.length > 0;
		for (Vector v:vecteurs) {
			result = Vector.sub(result, v);
		}
		return result;
	}

	public Vector opposé() {
		double[] opposedValues = new double[dimension()] ;
		for (int i=0;i<this.dimension();i++) {
			opposedValues[i] = - dimensions[i];
		}
		return new Vector(opposedValues);
	}
	
	public double get(int i) {
		return dimensions[i];
	}

	//une méthode qui prend 2 vecteurs de même dimension et construit leur produit scalaire
	public static double produitScalaire(Vector v1, Vector v2) {
		assert v1.dimension() == v2.dimension();
		double result = 0;
		for (int i=0;i<v1.dimension();i++) {
			result += v1.get(i) * v2.get(i);
		}
		return result;
	}

	public static Vector produitVectoriel(Vector v1, Vector v2) {
		assert v1.dimension() == v2.dimension() && v2.dimension() == 3;
		double d1 = v1.get(1) * v1.get(2) - v1.get(2) * v2.get(1) ;
		double d2 = v1.get(0) * v2.get(2) - v1.get(2) * v2.get(0);
		double d3 = v1.get(0) * v2.get(1) - v1.get(1) * v2.get(0);
		
		return new Vector(d1,d2,d3);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("<");
		for (int i=0; i< dimension();i++) {
			builder.append(dimensions[i]);
			if (i+1<dimension()) {
				builder.append(",");
			}
		}
		builder.append(">");
		return builder.toString();
	}


	
	public static boolean sameDimension(Vector... vecteurs) {
		if (vecteurs.length <= 1) {
			return true;
		}
		int nbDim = vecteurs[0].dimension();
		for (int i=1;i<vecteurs.length;i++) {
			if (nbDim != vecteurs[i].dimension()) {
				return false;
			}
		}
		return true;
	}
	
	
	

	public Vector multK(double k) {
		double[] values = new double[this.dimension()];
		for (int i=0;i<this.dimension();i++) {
			values[i] = dimensions[i] * k;
		}
		return new Vector(values);
	}
}
