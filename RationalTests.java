
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RationalTests {

    @Test
    public void addRationals(){
        Rational r1 = new Rational(3.5);
        Rational r2 = new Rational(3.5);
        assertEquals(r1.add(r2).getValue() == 7.0, true);
    }
}
