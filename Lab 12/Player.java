package monopoly;
/**
 * Models a player in a simulated game of Monopoly.
 * 
 * @author Amina Hajiyeva 101303729
 */
public class Player
{
    /** This player's name. */
    private String name;
    
    /** The square where this player is located. */
    private Square location;
    
    /** The game board. */
    private Board board;
    
    /** The dice shared by all players. */
    private Dice dice;     
    
    /**
     * Constructs a new player with the specified name. The player is
     * placed in the board's starting square.
     *
     * @param name The player's name.
     * @param board The game board.
     * @param dice The dice shared by all players.
     */
    public Player(String name, Board board, Dice dice)
    {
        this.name = name;
        this.board = board;
        this.dice = dice;
        location = board.startingSquare();
    }
  
    /**
     * Rolls the dice and moves this player by the number of squares
     * equal to the value rolled. 
     */
    public void takeTurn()
    {
        int rollTotal = dice.roll();
        System.out.println(name + " rolled " + rollTotal);
        location = board.nextSquare(location, rollTotal); 
        System.out.println(name + " landed on " + location.description()); 
    }
    
    /**
     * Returns the player's name.
     * @return The player's name.
     */
    public String name() 
    {
        return name;
    }
    
    /**
     * Returns the board this player is on.
     * @return The game board.
     */
    public Board board() 
    {
        return board;
    }
    
    /**
     * Returns the dice shared by all players.
     * @return The dice object.
     */
    public Dice dice() 
    {
        return dice;
    }
    
    /**
     * Returns the square where this player is located.
     * @return The current location of the player.
     */
    public Square location() 
    {
        return location;
    }
}

    
