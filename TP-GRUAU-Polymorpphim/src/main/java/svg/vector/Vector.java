package svg.vector;


import static svg.vector.VecteurUtils.sameDimension;

public class Vector implements IVecteur{
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

	@Override
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

	@Override
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

	@Override
	public Vector multK(double k) {
		double[] values = new double[this.dimension()];
		for (int i=0;i<this.dimension();i++) {
			values[i] = dimensions[i] * k;
		}
		return new Vector(values);
	}
}
