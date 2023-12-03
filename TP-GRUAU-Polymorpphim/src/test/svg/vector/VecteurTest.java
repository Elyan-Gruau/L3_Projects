package svg.vector;


import org.junit.Test;
import static org.junit.Assert.*;

public class VecteurTest {

    @Test
    public void testConstructorWithDimension() {
        Vecteur vecteur = new Vecteur(3, new double[]{1, 2});

        assertNotNull(vecteur);
        assertEquals(3, vecteur.dimension());
        assertEquals(1, vecteur.get(0), 0.0001);
        assertEquals(2, vecteur.get(1), 0.0001);
        assertEquals(0, vecteur.get(2), 0.0001);
    }

    @Test
    public void testConstructorWithoutDimension() {
        Vecteur vecteur = new Vecteur(1, 2, 3, 4);

        assertNotNull(vecteur);
        assertEquals(4, vecteur.dimension());
        assertEquals(1, vecteur.get(0), 0.0001);
        assertEquals(2, vecteur.get(1), 0.0001);
        assertEquals(3, vecteur.get(2), 0.0001);
        assertEquals(4, vecteur.get(3), 0.0001);
    }

    @Test
    public void testDimension() {
        Vecteur vecteur = new Vecteur(1, 2, 3);

        assertEquals(3, vecteur.dimension());
    }

    @Test
    public void testLength() {
        Vecteur vecteur = new Vecteur(1, 2, 2);

        double result = vecteur.length();

        assertEquals(3, result, 0.0001);
    }

    @Test
    public void testTranspose() {
        Vecteur vecteur = new Vecteur(1, 2);

        Vecteur transposed = vecteur.transpose();

        assertNotNull(transposed);
        assertEquals(2, transposed.dimension());
        assertEquals(2, transposed.get(0), 0.0001);
        assertEquals(1, transposed.get(1), 0.0001);
    }

    @Test
    public void testOppose() {
        Vecteur vecteur = new Vecteur(1, 2, 3);

        Vecteur opposed = vecteur.opposé();

        assertNotNull(opposed);
        assertEquals(-1, opposed.get(0), 0.0001);
        assertEquals(-2, opposed.get(1), 0.0001);
        assertEquals(-3, opposed.get(2), 0.0001);
    }

    @Test
    public void testGet() {
        Vecteur vecteur = new Vecteur(1, 2, 3);

        assertEquals(1, vecteur.get(0), 0.0001);
        assertEquals(2, vecteur.get(1), 0.0001);
        assertEquals(3, vecteur.get(2), 0.0001);
    }

    @Test
    public void testToString() {
        Vecteur vecteur = new Vecteur(1, 2, 3);

        String result = vecteur.toString();

        assertEquals("<1.0,2.0,3.0>", result);
    }

    @Test
    public void testMultK() {
        Vecteur vecteur = new Vecteur(1, 2, 3);

        Vecteur multiplied = vecteur.multK(2);

        assertNotNull(multiplied);
        assertEquals(2, multiplied.get(0), 0.0001);
        assertEquals(4, multiplied.get(1), 0.0001);
        assertEquals(6, multiplied.get(2), 0.0001);
    }
}
