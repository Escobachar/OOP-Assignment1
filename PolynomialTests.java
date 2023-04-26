import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

public class PolynomialTests {
    private Scalar s = new IntegerScalar(1);
    private Monomial m1 = new Monomial(1, s);
    private Monomial m2 = new Monomial(2, s);
    private Monomial m3 = new Monomial(3, s);
    private Monomial m4 = new Monomial(4, s);
    private Collection<Monomial> monos1 = new ArrayList<Monomial>(Arrays.asList(m1,m2,m3,m4));
    private Collection<Monomial> monos2 = new ArrayList<Monomial>(Arrays.asList(m3,m4));
    private Collection<Monomial> monos3 = new ArrayList<Monomial>(Arrays.asList(m1,m2));
    private Polynomial p1 = new Polynomial(monos1);
    private Polynomial p2 = new Polynomial(monos2);
    private Polynomial p3 = new Polynomial(monos3);
    
    @Test
    public void createPolynomial(){
        assertEquals(p1, new Polynomial(monos2, monos3));


    }



    
}
