/**
 * PlayerRollUntilPrimeNumber models a player with the Chance It game strategy of
 * rolling the dice until the player rolls a prime number
 *
 * @author Lynn Marshall
 * @version Lab 6 Starting Point
 * @author Amina Hajiyeva 101303729
 */
public class PlayerRollUntilPrimeNumber extends Player
{
    /**
     * Constructor for objects of class PlayerRollUntilPrimeNumber
     * 
     * @param dice The pair of dice shared by all players.
     * @param name The player's name.
     */
    public PlayerRollUntilPrimeNumber(Dice dice, String name)
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
    private boolean checkIfPrime(int num)
    {
        if(num <= 1)
            return false;
            
        for(int i = 2; i * i <= num; i++)
        {
            if(num % i == 0)
                return false;
        }
        return true;
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
    protected boolean stopRolling() 
    {
        return checkIfPrime(currentRoll);
    }
}
