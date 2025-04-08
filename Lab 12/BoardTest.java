package monopoly.test;
import monopoly.Board;
import monopoly.Square;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll; // added
import org.junit.jupiter.api.AfterAll; // added
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * The test class BoardTest.
 *
 * @author Amina Hajiyeva 101303729
 */
public class BoardTest
{
    private Board board;
    
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
        board = new Board();
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
     * Tests that starting square is 1 (Go)
     */
    @Test
    public void testStartingSquare() 
    {
        System.out.println("testing testStartingSquare...");
        Square start = board.startingSquare();
        assertEquals(1, start.number());
    }

    /**
     * Test the squares on the board are consequitively numbered from 1 to 40.
     */
    @Test
    public void testConsecutiveNumbering() 
    {
        System.out.println("testing testConsecutiveNumbering...");
        Square current = board.startingSquare();
        
        for (int i = 1; i < 40; i++) 
        {
            Square next = board.nextSquare(current, 1);
            assertEquals((current.number() % 40) + 1, next.number());
            current = next;
        }
    }

    /**
     * Test that expected square is returned from the range 2-12 (starting at Go [1]).
     */
    @Test
    public void testNextSquareDistance2to12() 
    {
        System.out.println("testing testNextSquareDistance2to12...");
        Square current = board.startingSquare();
        
        for (int distance = 2; distance <= 12; distance++) 
        {
            Square destination = board.nextSquare(current, distance);
            int expected = ((current.number() - 1 + distance) % 40) + 1;
            assertEquals(expected, destination.number());
        }
    }

    /**
     * Test moving from square 40 wraps back around to beginning (Go).
     */
    @Test
    public void testWrapAroundFromEnd() 
    {
        System.out.println("testing testWrapAroundFromEnd...");

        Square square39 = board.nextSquare(board.startingSquare(), 38); // go to 39 and move up two to wrap back to Go
        assertEquals(39, square39.number());

        Square square40 = board.nextSquare(square39, 1);
        assertEquals(40, square40.number());

        Square wrapped = board.nextSquare(square40, 1);
        assertEquals(1, wrapped.number()); // is supposed to wrap to square 1
    }
}
