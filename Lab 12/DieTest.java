package monopoly.test;
import monopoly.Die;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll; // added
import org.junit.jupiter.api.AfterAll; // added
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Random;
/**
 * The test class DieTest.
 *
 * @author Amina Hajiyeva 101303729
 */
public class DieTest
{
    private Die die;
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
        Random r = new Random();
        die = new Die(r);
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
     * Testing the roll range of the die
     */
    @Test
    public void testRollRange() 
    {
        System.out.println("testing testRollRange...");
        for (int i = 0; i < 1000; i++) 
        {
            int roll = die.roll();
            assertTrue(roll >= 1 && roll <= 6, "Roll out of bounds: " + roll);
        }
    }
}
