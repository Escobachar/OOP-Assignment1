import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

public class PolynomialTests {
    private Scalar s = new IntegerScalar(1);
    private Scalar s2 = new IntegerScalar(2);
    private Monomial m1 = new Monomial(1, s);
    private Monomial m2 = new Monomial(2, s);
    private Monomial m3 = new Monomial(3, s);
    private Monomial m4 = new Monomial(4, s);
    private Monomial m5 = new Monomial(2, s2);
    private Collection<Monomial> monos1 = new ArrayList<Monomial>(Arrays.asList(m1,m2,m3,m4));
    private Collection<Monomial> monos2 = new ArrayList<Monomial>(Arrays.asList(m3,m4));
    private Collection<Monomial> monos3 = new ArrayList<Monomial>(Arrays.asList(m1,m2));
    private Collection<Monomial> monos4 = new ArrayList<Monomial>(Arrays.asList(m1));
    private Collection<Monomial> monos5 = new ArrayList<Monomial>(Arrays.asList(m2));
    private Collection<Monomial> monos6 = new ArrayList<Monomial>(Arrays.asList(m5));

    
    private Polynomial p1 = new Polynomial(monos1);
    private Polynomial p2 = new Polynomial(monos2);
    private Polynomial p3 = new Polynomial(monos3);
    private Polynomial p4 = new Polynomial(monos4);
    private Polynomial p5 = new Polynomial(monos5);
    private Polynomial p6 = new Polynomial(monos6);

    
    @Test
    public void createPolynomial(){
        assertEquals(p1, new Polynomial(monos2, monos3));
    }

    @Test
    public void buildTest(){
        String s = "0 1 1 1 1";
        assertEquals(Polynomial.build(s).toString(), p1.toString());
    }
    
    @Test
    public void addTest(){
        assertEquals(p1, p2.add(p3));
        assertEquals(p1, p3.add(p2));
        assertEquals(p1.add(p2), p2.add(p3).add(p2));
    }

    @Test
    public void mulTest(){
        assertEquals(p4.mul(p5), p5.mul(p4));
    }

    @Test
    public void evaluateTest(){
        double val1 = 1.0;
        double val2 = 2.0;
        double val3 = 4.0;
        assertTrue(val1 == p4.evaluate(s).getValue());
        assertTrue(val2 == p2.evaluate(s).getValue());
        assertTrue(val3 == p1.evaluate(s).getValue());
    }
    
    @Test
    public void derivativeTest(){
        assertEquals(p1.derivative(),p1.derivative());
        assertTrue(p4.derivative().evaluate(s).getValue()==p5.derivative().derivative().evaluate(s).getValue()*0.5);
        assertTrue(p6.derivative().evaluate(s).getValue()==p4.evaluate(s).getValue()*4);
    }

    @Test
    public void equalsTest(){
        assertFalse(p1.equals(p2));
        assertTrue(p1.equals(p1));
        Polynomial pTest = Polynomial.build("0 0 2");
        assertTrue(p6.equals(pTest));
    }

    @Test
    public void toStringTest(){
        String result1 = "x^1";
        String result2 = "2x^2";
        String result3 = "x^2";
        String result4 = "x^1+x^2+x^3+x^4";
        assertEquals(result1, p4.toString());
        assertEquals(result2, p6.toString());
        assertEquals(result3, p5.toString());
        assertEquals(result4, p1.toString());
    }


}
