/**
 * PlayerRollFourTimes models a player with the Chance It game strategy of
 * always rolling the dice four times.
 *
 * @author Lynn Marshall
 * @version Lab 6 Starting Point
 * @author Amina Hajiyeva 101303729
 */
public class PlayerRollFourTimes extends Player
{
    /**
     * Constructor for objects of class PlayerRoll4
     * 
     * @param dice The pair of dice shared by all players.
     * @param name The player's name.
     */
    public PlayerRollFourTimes(Dice dice, String name)
    {
        super(dice, name);
    }

    /** 
     * Encapsulates the strategy used by this player to determine when to 
     * stop rolling the dice during each turn.
     * 
     * All concrete subclasses must provide a strategy for the player
     * 
     * @return true when the player decides to end their current turn;
     *         otherwise returns false.
     */
    protected boolean stopRolling() {
        return numRolls==4;
    }
}
