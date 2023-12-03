package svg.vector;


import org.junit.Test;
import static org.junit.Assert.*;

public class VectorTest {

    @Test
    public void testConstructorWithDimension() {
        Vector vector = new Vector(3, new double[]{1, 2});

        assertNotNull(vector);
        assertEquals(3, vector.dimension());
        assertEquals(1, vector.get(0), 0.0001);
        assertEquals(2, vector.get(1), 0.0001);
        assertEquals(0, vector.get(2), 0.0001);
    }

    @Test
    public void testConstructorWithoutDimension() {
        Vector vector = new Vector(1, 2, 3, 4);

        assertNotNull(vector);
        assertEquals(4, vector.dimension());
        assertEquals(1, vector.get(0), 0.0001);
        assertEquals(2, vector.get(1), 0.0001);
        assertEquals(3, vector.get(2), 0.0001);
        assertEquals(4, vector.get(3), 0.0001);
    }

    @Test
    public void testDimension() {
        Vector vector = new Vector(1, 2, 3);

        assertEquals(3, vector.dimension());
    }

    @Test
    public void testLength() {
        Vector vector = new Vector(1, 2, 2);

        double result = vector.length();

        assertEquals(3, result, 0.0001);
    }

    @Test
    public void testTranspose() {
        Vector vector = new Vector(1, 2);

        Vector transposed = vector.transpose();

        assertNotNull(transposed);
        assertEquals(2, transposed.dimension());
        assertEquals(2, transposed.get(0), 0.0001);
        assertEquals(1, transposed.get(1), 0.0001);
    }

    @Test
    public void testOppose() {
        Vector vector = new Vector(1, 2, 3);

        Vector opposed = vector.opposé();

        assertNotNull(opposed);
        assertEquals(-1, opposed.get(0), 0.0001);
        assertEquals(-2, opposed.get(1), 0.0001);
        assertEquals(-3, opposed.get(2), 0.0001);
    }

    @Test
    public void testGet() {
        Vector vector = new Vector(1, 2, 3);

        assertEquals(1, vector.get(0), 0.0001);
        assertEquals(2, vector.get(1), 0.0001);
        assertEquals(3, vector.get(2), 0.0001);
    }

    @Test
    public void testToString() {
        Vector vector = new Vector(1, 2, 3);

        String result = vector.toString();

        assertEquals("<1.0,2.0,3.0>", result);
    }

    @Test
    public void testMultK() {
        Vector vector = new Vector(1, 2, 3);

        Vector multiplied = vector.multK(2);

        assertNotNull(multiplied);
        assertEquals(2, multiplied.get(0), 0.0001);
        assertEquals(4, multiplied.get(1), 0.0001);
        assertEquals(6, multiplied.get(2), 0.0001);
    }
}
