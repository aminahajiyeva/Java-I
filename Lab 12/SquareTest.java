package monopoly.test;
import monopoly.Square;
import monopoly.Money;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll; // added
import org.junit.jupiter.api.AfterAll; // added
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * The test class SquareTest.
 *
 * @author Amina Hajiyeva 101303729
 */
public class SquareTest
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
     * Test all squares
     */
    @Test
    public void testSquare()
    {
        //test go square
        System.out.println("testing GO square...");
        Square go = new Square(Square.GO, "Go", 1);
        assertEquals(Square.GO, go.type());
        assertEquals("Go", go.name());
        assertEquals(1, go.number());
        assertEquals(new Money(200,0).toString(),go.salary().toString());
        assertNull(go.price());
        assertNull(go.maximumTax());
        
        //test lot square
        System.out.println("testing lot square...");
        Square lot = new Square(Square.LOT, "Princess Street", 2);
        Money price = new Money(60, 0);
        lot.setPrice(price);
        assertEquals(Square.LOT, lot.type());
        assertEquals("Princess Street", lot.name());
        assertEquals(2, lot.number());
        assertEquals(price.toString(), lot.price().toString());
        assertNull(lot.salary());
        assertNull(lot.maximumTax());
        
        //test income square tax
        System.out.println("Testing income square tax...");
        Square tax = new Square(Square.INCOME_TAX, "Income Tax", 3);
        assertEquals(Square.INCOME_TAX, tax.type());
        assertEquals("Income Tax", tax.name());
        assertEquals(3, tax.number());
        assertEquals(new Money(200,0).toString(),tax.maximumTax().toString());
        assertNull(tax.salary());
        assertNull(tax.price());
        
        //test empty square
        System.out.println("testing empty square...");
        Square empty = new Square(Square.EMPTY, "Chance", 4);
        assertEquals(Square.EMPTY, empty.type());
        assertEquals("Chance", empty.name());
        assertEquals(4, empty.number());
        assertNull(empty.salary());
        assertNull(empty.maximumTax());
        assertNull(empty.price());
    }
}
