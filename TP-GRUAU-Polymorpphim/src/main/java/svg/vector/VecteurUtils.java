package svg.vector;

public class VecteurUtils {

    public static boolean sameDimension(IVecteur... vecteurs) {
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

    public static IVecteur produitVectoriel(IVecteur v1, IVecteur v2) {
        assert v1.dimension() == v2.dimension() && v2.dimension() == 3;
        double d1 = v1.get(1) * v1.get(2) - v1.get(2) * v2.get(1) ;
        double d2 = v1.get(0) * v2.get(2) - v1.get(2) * v2.get(0);
        double d3 = v1.get(0) * v2.get(1) - v1.get(1) * v2.get(0);

        return new Vector(d1,d2,d3);
    }

    public static IVecteur fabriqueVecteur(double ... components) {
        return components.length == 2 ?
                new Vecteur2D(components[0], components[1]) :
                new Vector(components);
    }

    //une méthode qui prend 2 vecteurs de même dimension et construit leur produit scalaire
    public static double produitScalaire(IVecteur v1, IVecteur v2) {
        assert v1.dimension() == v2.dimension();
        double result = 0;
        for (int i=0;i<v1.dimension();i++) {
            result += v1.get(i) * v2.get(i);
        }
        return result;
    }

    public static IVecteur add(Vector... vecteurs) {
        assert vecteurs !=  null && vecteurs.length >= 2;

        int requiredDim = vecteurs[0].dimension();
        for (int i=1;i<vecteurs.length;i++) {
            assert requiredDim == vecteurs[i].dimension() : "Les vecteurs ne sont pas de la même dimension.";
        }


        IVecteur result =  vecteurs[0];
        for (int i=1;i<vecteurs.length; i++) {
            result = VecteurUtils.add(result, vecteurs[i]);
        }
        return result;
    }

    //une méthode qui prend n vecteurs de même dimension et construit leur somme
    public static IVecteur add(IVecteur v0, IVecteur v1) {
        assert  VecteurUtils.sameDimension(v0,v1) : "Les vecteurs ne sont pas de la même dimension" ;
        assert v0.dimension() == v1.dimension();
        double[] resultValues = new double[v0.dimension()];

        for (int i=0; i<v0.dimension() ;i++) {
            resultValues[i] = v0.get(i) + v1.get(i) ;
        }
        return fabriqueVecteur(resultValues);
    }

    public static IVecteur sub(IVecteur v0, IVecteur v1) {
        assert VecteurUtils.sameDimension(v0,v1) : "Les vecteurs ne sont pas de la même dimension" ;
        assert v0.dimension() == v1.dimension();
        double[] resultValues = new double[v0.dimension()];

        for (int i=0; i<v0.dimension() ;i++) {
            resultValues[i] = v0.get(i) - v1.get(i) ;
        }
        return new Vector(resultValues);
    }

    //une méthode qui prend n vecteurs de même dimension et construit leur différence
    public static IVecteur sub(IVecteur v0, IVecteur v1, IVecteur... vecteurs) {
        IVecteur result =  VecteurUtils.sub(v0, v1);
        assert vecteurs !=  null && vecteurs.length > 0;
        for (IVecteur v:vecteurs) {
            result = VecteurUtils.sub(result, v);
        }
        return result;
    }

    public static double produitVectoriel(Vecteur2D v1,Vecteur2D v2) {
        return  v1.getX() * v2.getY() - v1.getY()* v2.getX();
    }

}
