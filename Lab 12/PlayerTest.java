package monopoly.test;
import monopoly.Player;
import monopoly.Board;
import monopoly.Dice;
import monopoly.Square;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll; // added
import org.junit.jupiter.api.AfterAll; // added
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * The test class PlayerTest.
 *
 * @author Amina Hajiyeva 101303729
 */
public class PlayerTest
{
    private Player player;
    private Board board;
    private Dice dice;

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
        board = new Board();
        dice = new Dice();
        player = new Player("Amina", board, dice);
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
     * Test that player is set up correctly.
     */
    @Test
    public void testPlayerSetup() 
    {
        System.out.println("testing testPlayerSetup...");

        assertEquals("Amina", player.name());
        assertEquals(board, player.board());
        assertEquals(dice, player.dice());
        assertEquals(board.startingSquare(), player.location());
    }
}
