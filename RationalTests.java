import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;
import org.junit.Test;

public class RationalTests {
    private Double value = 4.5;
    private Rational r1 = new Rational(3.5);
    private Rational r2 = new Rational(2.0);
    private Rational r3 = new Rational(0.0);
    private Rational r4 = new Rational(0, 1);
    private Rational r5 = new Rational(value);
    private Rational r6 = new Rational(9,2);
    private Rational r7 = new Rational(-9,2);
    private Rational r8 = new Rational(9,-2);
    private Rational r9 = new Rational(81,4);
    private Rational r10 = new Rational(100,200);
    private Rational r11 = new Rational(1,2);




    
    @Test
    public void createRational(){
        assertEquals(Rational.class, r6.getClass());
        assertEquals(Rational.class, r5.getClass());
        assertTrue(r5.getValue() == 4.5);
        assertTrue(r6.getValue() == 4.5);
        assertEquals(r6, r5);
        assertThrows(IllegalArgumentException.class,()->{
            new Rational(1, 0);
        } );
    }
    @Test
    public void addTest(){
        assertEquals(r1, r1.add(r3));
        assertEquals(r1, r1.add(r4));
        assertTrue(r1.add(r2).getValue() == 5.5);
    }
    @Test
    public void mulTest(){
        assertTrue(r1.mul(r3).getValue() ==0);
        assertTrue(r1.mul(r2).getValue() ==7.0);
        assertEquals(r1.mul(r3),r3);
    }

    @Test
    public void negTest(){
        assertTrue(r1.neg().getValue()== -3.5);
        assertEquals(r6.neg(),r7);
        assertEquals(r6.neg(),r8);
        assertEquals(r6.neg().neg(),r6);
    }

    @Test
    public void powerTest(){
        assertEquals(r6.power(2),r9);
        assertEquals(r6.power(2).power(2),r9.power(2));
        assertEquals(r6.power(4),r9.power(2));
    }

    @Test
    public void signTest(){
        assertTrue(r7.sign()== -1);
        assertTrue(r6.sign()== 1);
        assertTrue(r8.sign()== -1);
        assertTrue(r3.sign()== 0);
    }

    @Test
    public void equalsTest(){
        assertEquals(r3,r4);
        assertEquals(r7,r8);
    } 
    @Test
    public void getValueTest(){
        assertTrue(value == r5.getValue());
    }

    @Test
    public void toStringTest(){
        String acspectedString1 = "9/2";
        String acspectedString2 = "-9/2";
        String acspectedString3 = "2";
        assertEquals(acspectedString1, r6.toString());
        assertEquals(acspectedString2, r8.toString());
        assertEquals(acspectedString3, r2.toString());
    }

    @Test
    public void reduceTest(){
        assertEquals(r10.reduce(),r11);
        assertEquals(r11.reduce(),r11);
    }

}
