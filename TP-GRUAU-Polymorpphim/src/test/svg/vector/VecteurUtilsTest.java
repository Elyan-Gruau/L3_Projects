package svg.vector;

import org.junit.Test;
import static org.junit.Assert.*;

public class VecteurUtilsTest {

    @Test
    public void testSameDimension() {
        Vecteur2D vecteur1_2D = new Vecteur2D(1, 2);
        Vecteur2D vecteur2_2D = new Vecteur2D(98, 32);
        Vector vector3_3D = new Vector(3, 4, 5);
        Vector vector4_3D = new Vector(63, 78, 1);

        assertFalse(VecteurUtils.sameDimension(vecteur1_2D, vector3_3D));
        assertTrue(VecteurUtils.sameDimension(vecteur1_2D, vecteur2_2D));
        assertTrue(VecteurUtils.sameDimension(vector3_3D, vector4_3D));
    }

    @Test
    public void testProduitVectoriel() {
        Vecteur2D v1 = new Vecteur2D(1, 2);
        Vecteur2D v2 = new Vecteur2D(3, 4);

        double result = VecteurUtils.produitVectoriel(v1, v2);
        double expectedResult = v1.getX() * v2.getY() - v1.getY()* v2.getX();

        assertNotNull(result);
        assertEquals(expectedResult, result, 0.0001);
    }

    @Test
    public void testFabriqueVecteur() {
        IVecteur vecteur3D = VecteurUtils.fabriqueVecteur(1, 2, 3);

        assertNotNull(vecteur3D);
        assertEquals(1, vecteur3D.get(0), 0.0001);
        assertEquals(2, vecteur3D.get(1), 0.0001);
        assertEquals(3, vecteur3D.get(2), 0.0001);
        assertTrue(vecteur3D instanceof Vector );

        IVecteur vecteur2D = VecteurUtils.fabriqueVecteur(1, 2);
        assertEquals(1, vecteur3D.get(0), 0.0001);
        assertEquals(2, vecteur3D.get(1), 0.0001);
        assertTrue(vecteur2D instanceof Vecteur2D );
    }

    @Test
    public void testProduitScalaire() {
        IVecteur v1 = new Vecteur2D(1, 2);
        IVecteur v2 = new Vecteur2D(3, 4);

        double result = VecteurUtils.produitScalaire(v1, v2);

        assertEquals(11, result, 0.0001);
    }

    @Test
    public void testAdd() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(4, 5, 6);

        IVecteur result = VecteurUtils.add(v1, v2);

        assertNotNull(result);
        assertEquals(5, result.get(0), 0.0001);
        assertEquals(7, result.get(1), 0.0001);
        assertEquals(9, result.get(2), 0.0001);
    }

    @Test
    public void testSub() {
        Vecteur2D v1 = new Vecteur2D(4, 5);
        Vecteur2D v2 = new Vecteur2D(1, 2);

        IVecteur result = VecteurUtils.sub(v1, v2);

        assertNotNull(result);
        assertEquals(3, result.get(0), 0.0001);
        assertEquals(3, result.get(1), 0.0001);
    }

    @Test
    public void testSubWithMultipleVectors() {
        Vector v1 = new Vector(4, 5, 6);
        Vector v2 = new Vector(1, 2, 3);
        Vector v3 = new Vector(2, 1, 1);

        IVecteur result = VecteurUtils.sub(v1, v2, v3);

        assertNotNull(result);
        assertEquals(1, result.get(0), 0.0001);
        assertEquals(2, result.get(1), 0.0001);
        assertEquals(2, result.get(2), 0.0001);
    }

    @Test
    public void testProduitVectoriel2D() {
        Vecteur2D v1 = new Vecteur2D(2, 3);
        Vecteur2D v2 = new Vecteur2D(4, 1);

        double result = VecteurUtils.produitVectoriel(v1, v2);

        assertEquals(-10, result, 0.0001);
    }
}
