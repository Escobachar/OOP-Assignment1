import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
public class IntegerScalarTests {
    Scalar s1 = new IntegerScalar(5);
    Scalar s2 = new IntegerScalar(0);
    Scalar s3 = new IntegerScalar(2);
    Scalar r1 = new Rational(2.5);
    @Test
    public void addIntegerScalarTest(){
        assertEquals(s2.add(s1),s1);
        assertEquals(s1.add(s1),new IntegerScalar(10));
        assertEquals(s1.add(r1),new Rational(7.5));
    }
    @Test
    public void mulIntegerScalarTest(){
        assertEquals(s1.mul(s2),s2);
        assertEquals(s1.mul(new IntegerScalar(-1)),s1.neg());
        assertEquals(s3.mul(r1),s1);
    }
    @Test
    public void negIntegerScalarTest(){
        assertEquals(s1.neg(), new IntegerScalar(-5));
    }
    @Test
    public void powerIntegerScalarTest(){
        assertEquals(s1.power(2),new IntegerScalar(25));
    }
    @Test
    public void signIntegerScalarTest(){
        assertTrue(s1.sign() == 1);
        assertTrue(s2.sign() == 0);
        assertTrue(s1.neg().sign() == -1);
    }
    @Test
    public void equalsIntegerScalarTest(){
        assertTrue(s1.equals(new Rational(5.0)));
        assertTrue(!s1.equals(s2));

    }
    @Test
    public void toStringIntegerScalarTest(){
       assertEquals(s1.toString(),"5");
    }

}
