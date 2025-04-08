package monopoly.test;
import monopoly.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

/**
 * The test class DiceTest.
 *
 * @author Amina Hajiyeva 101303729
 */
public class DiceTest
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
     * The tests ensure that 1000 rolls are within the valid range, 2-12.
     */
    @Test
    public void testDiceRollRange() 
    {
        System.out.println("testing DiceRollRange");
        Dice dice = new Dice();
        for(int i = 0; i < 1000; i++)
        {
            int result = dice.roll();
            assertTrue(result >= 2 && result <= 12, "Dice roll out of range" + result);
        }
    }
}
