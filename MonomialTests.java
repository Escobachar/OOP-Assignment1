import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MonomialTests{
    Scalar s1 = new IntegerScalar(5);
    Scalar s2 = new IntegerScalar(2);
    Scalar s3 = new Rational(2.5);
    Monomial m1 = new Monomial(2,s1);
    Monomial m2 = new Monomial(3,s2);
    Monomial m3 = new Monomial(2,s2);
    Monomial m4 = new Monomial(2,s3);

    @Test
    public void addMonomialTest(){
        assertNull(m1.add(m2));
        assertEquals(m1.add(m3),new Monomial(2,s1.add(s2)));
    }
    @Test
    public void mulMonomialTest(){
        assertEquals(m1.mul(m2), new Monomial(5,s1.mul(s2)));
    }
    @Test
    public void evaluateMonomialTest(){
        assertEquals(m1.evaluate(s1), new IntegerScalar(125));
    }
    @Test
    public void derivativeMonomialTest(){
        assertEquals(m4.derivative(),new Monomial(1,new IntegerScalar(5)));
    }
    @Test
    public void signMonomialTest(){
        assertEquals(m1.sign(),s1.sign());
    }
    @Test
    public void equalsMonomialTest(){
        assertTrue(!m1.equals(m2));
        assertTrue(!m1.equals(s1));
        assertTrue(m1.equals(new Monomial(2,new Rational(5.0))));
    }
    @Test
    public void toStringTest(){
        Monomial m5 = new Monomial(0,new IntegerScalar(1));
        Monomial m6 = new Monomial(1,s1);
        Monomial m7 = new Monomial(123,new IntegerScalar(0));
        String v1 = "5x^2";
        String v5 = "1";
        String v6 = "5x";
        String v7 = "0";
        assertEquals(m1.toString(),v1);
        assertEquals(m5.toString(),v5);
        assertEquals(m6.toString(),v6);
        assertEquals(m7.toString(),v7);
    }
}
