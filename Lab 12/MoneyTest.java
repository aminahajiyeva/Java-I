package monopoly.test;
import monopoly.Money;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll; // added
import org.junit.jupiter.api.AfterAll; // added
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * The test class MoneyTest.
 *
 * @author Amina Hajiyeva 101303729
 */
public class MoneyTest
{
    /**
     * initializes class
     */
    @BeforeAll
    public static void init() 
    {
        System.out.println("init() ran");
    }
    
    /**
     * closes object
     */
    @AfterAll
    public static void close() 
    {
        System.out.println("close() ran");
    }
    
    /**
     * sets up object
     */
    @BeforeEach
    public void setUp() 
    {
        System.out.println("setUp() ran");
    }
    
    /**
     * Tearsdown the object
     */
    @AfterEach
    public void tearDown() 
    {
        System.out.println("tearDown() ran");
    }
    
    /**
     * Test that IsEqualTo works correctly
     */
    @Test
    public void IsEqualTo() 
    {
        System.out.println("testing testIsEqualTo");

        Money m1 = new Money(500); // 5 dollars
        Money m2 = new Money(5, 0); // 5 dollars
        Money m3 = new Money(4, 100); // 5 dollars
        Money m4 = new Money(50); // 5 dollars

        assertTrue(m1.isEqualTo(m2));
        assertTrue(m1.isEqualTo(m3));
        assertFalse(m1.isEqualTo(m4));
    }

    /**
     * Test that plus works correctly
     */
    @Test
    public void testPlus() 
    {
        System.out.println("testing testPlus");

        Money m1 = new Money(300); // $3.00
        Money m2 = new Money(200); // $2.00
        Money result = m1.plus(m2); // should be $5.00
        assertTrue(result.isEqualTo(new Money(500)));

        // test with cents
        Money m3 = new Money(1, 95); // $1.95
        Money m4 = new Money(0, 50); // $0.50
        Money result2 = m3.plus(m4); // $2.45
        assertTrue(result2.isEqualTo(new Money(2, 45)));
    }

    /**
     * Test that minus works correctly
     */
    @Test
    public void testMinus() 
    {
        System.out.println("testing testMinus");

        Money m1 = new Money(650); // $6.50
        Money m2 = new Money(200); // $2.00
        Money result = m1.minus(m2); // $4.50
        assertTrue(result.isEqualTo(new Money(450)));

        // test with cents
        Money m3 = new Money(5, 0); // $5.00
        Money m4 = new Money(2, 50); // $2.50
        Money result2 = m3.minus(m4); // $2.50
        assertTrue(result2.isEqualTo(new Money(2, 50)));

        // test with negative result
        Money m5 = new Money(1, 0); // $1.00
        Money m6 = new Money(2, 0); // $2.00
        Money result3 = m5.minus(m6); // -$1.00
        assertTrue(result3.isEqualTo(new Money(-100)));
    }
    
}
