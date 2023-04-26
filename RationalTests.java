import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RationalTests {

    @Test
    public void createRational(){
        Double value = 4.5;
        Rational r1 = new Rational(value);
        Rational r2 = new Rational(9,2);
        assertEquals(Rational.class, r2.getClass());
        assertEquals(Rational.class, r1.getClass());
        assertTrue(r1.getValue() == 4.5);
        assertTrue(r2.getValue() == 4.5);
        assertEquals(r2, r1);
        assertThrows(IllegalArgumentException.class,()->{
            new Rational(1, 0);
        } );   
    }


    @Test
    public void addRationals(){
        Rational r1 = new Rational(3.5);
        Rational r2 = new Rational(3.5);
        Rational r3 = new Rational(0.0);
        Rational r4 = new Rational(0, 1);
        assertEquals(r1, r1.add(r3));
        assertEquals(r1, r1.add(r4));
        assertTrue(r1.add(r2).getValue() == 7.0);
        
    }
}
