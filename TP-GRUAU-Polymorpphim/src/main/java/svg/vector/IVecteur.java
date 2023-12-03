package svg.vector;

public interface IVecteur {
    int dimension();
    double length();
     IVecteur opposé();
    IVecteur multK(double k);

    double get(int index);
}
