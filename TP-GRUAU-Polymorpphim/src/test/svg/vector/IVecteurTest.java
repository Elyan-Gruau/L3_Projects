package svg.vector;

import org.junit.Test;
import static org.junit.Assert.*;

public class IVecteurTest {

    @Test
    public void testDimension() {
        IVecteur vecteur2D = new Vecteur2D(1, 2);
        IVecteur vector = new Vector(3, 4, 5);

        assertEquals(2, vecteur2D.dimension());
        assertEquals(3, vector.dimension());
    }

    @Test
    public void testLength() {
        IVecteur vecteur2D = new Vecteur2D(3, 4);
        IVecteur vector = new Vector(1, 2, 2);

        assertEquals(5, vecteur2D.length(), 0.0001);
        assertEquals(3, vector.length(), 0.0001);
    }

    @Test
    public void testOppose() {
        IVecteur vecteur2D = new Vecteur2D(1, 2);
        IVecteur vector = new Vector(3, 4, 5);

        IVecteur oppose2D = vecteur2D.opposé();
        IVecteur opposeVector = vector.opposé();

        assertNotNull(oppose2D);
        assertNotNull(opposeVector);

        assertEquals(-1, oppose2D.get(0), 0.0001);
        assertEquals(-2, oppose2D.get(1), 0.0001);

        assertEquals(-3, opposeVector.get(0), 0.0001);
        assertEquals(-4, opposeVector.get(1), 0.0001);
        assertEquals(-5, opposeVector.get(2), 0.0001);
    }

    @Test
    public void testMultK() {
        IVecteur vecteur2D = new Vecteur2D(1, 2);
        IVecteur vector = new Vector(3, 4, 5);

        IVecteur multK2D = vecteur2D.multK(2);
        IVecteur multKVector = vector.multK(3);

        assertNotNull(multK2D);
        assertNotNull(multKVector);

        assertEquals(2, multK2D.get(0), 0.0001);
        assertEquals(4, multK2D.get(1), 0.0001);

        assertEquals(9, multKVector.get(0), 0.0001);
        assertEquals(12, multKVector.get(1), 0.0001);
        assertEquals(15, multKVector.get(2), 0.0001);
    }

    @Test
    public void testGet() {
        IVecteur vecteur2D = new Vecteur2D(1, 2);
        IVecteur vector = new Vector(3, 4, 5);

        assertEquals(1, vecteur2D.get(0), 0.0001);
        assertEquals(2, vecteur2D.get(1), 0.0001);
        assertEquals(Double.NaN, vecteur2D.get(2), 0.0001);

        assertEquals(3, vector.get(0), 0.0001);
        assertEquals(4, vector.get(1), 0.0001);
        assertEquals(5, vector.get(2), 0.0001);
    }
}
