import java.util.ArrayList;
/**
 * ChanceItGame plays the game of Chance-It, the simple dice game introduced
 * by Joel Adams at Calvin College in the late 1990's.
 * 
 * @author D.L. Bailey, SCE, Carleton University
 * @version 1.03 January 17, 2007
 * 
 * @author Lynn Marshall
 * @version Lab 6 Starting Point
 * @Amina Hajiyeva 101303729
 */
public class ChanceItGame
{
    /* The number of rounds in a game.*/
    private int numberOfRounds;

    /* The players in the game. */
    private ArrayList<Player> players;

    /* The most recent player score. */
    private int turnScore;

    /**
     * Constructs a new Chance-It game with the specified number of rounds.
     * 
     * @param rounds The number of rounds in a game.
     */
    public ChanceItGame(int rounds)
    {
        numberOfRounds = rounds;
        players = new ArrayList<Player>();
        Dice dice = new Dice();
        turnScore = 0;
        players.add(new PlayerRollThreeTimes(dice,"Roll 3 Times"));
        players.add(new PlayerMinimumSeven(dice,"Minimum 7"));
        players.add(new PlayerMinimumOpponent(dice,"Minimum Prev Opp"));
        // add at least two more players with different strategies here (you will have created the Player subclasses in Part 2)
        players.add(new PlayerRollFourTimes(dice, "Roll 4 Times"));
        players.add(new PlayerRollUntilPrimeNumber(dice, "Roll Until Prime Number"));

    }

    /**
     * Plays one game of Chance-It, as long as there are at least two players.
     */
    public void playGame()
    {
        /* just return if there are fewer than two players (i.e. do nothing). */
        // add the required code here 
        if(players.size() < 2)
            return;

        /* Reset all players total scores with a foreach loop. */
        // add the required code here
        for(Player elements:players)
        {
            elements.resetTotalScore();
        }

        // the remaining code is unchanged
        for (int round = 1; round <= numberOfRounds; round++) {
            playOneRound(round);
        }
        announceResults();
    }

    /**
     * Play one round of the game.
     * 
     * @param round the round number.
     */
    private void playOneRound(int round)
    {
        System.out.println("Round " + round + ":");
        int initialTurn = 1;

        // Each player takes a turn using a foreach loop
        // add the required code here
        for(Player elements: players)
        {
            turnScore = elements.takeTurn(initialTurn);
            initialTurn ++;
        }

        // Summarize the results of this round.
        System.out.println("*************************************");
        System.out.println("After round " + round); 

        // Summarize player names and scores using a foreach loop
        // add the required code here
        for(Player elements: players)
        {
            System.out.println(elements.name() + "," + elements.score());
        }

        System.out.println("*************************************");
        System.out.println();
    }

    /**
     * Determines which player won the game or if there is a tie, 
     * and displays the results.
     */
    private void announceResults()
    {
        ArrayList<String> winners = new ArrayList<String>(); // the name(s) of the winners

        int highScore = 0;
        // find the highest score using a foreach loop (store it in highScore)
        // add the required code here

        for(Player elements: players)
        {
            if(elements.score() > highScore)
            {
                highScore = elements.score();
            }
        }

        // put all those names with highest score in the winners list using a foreach loop
        // add the required code here

        for(Player elements: players)
        {
            if(elements.score() == highScore)
            {
                winners.add(elements.name());
            }
        }

        // print the winner(s)
        // if there is just one winner, print the winner as was done in v1 and return
        // add the required code here
        
        if (winners.size() == 1)
        {
            System.out.println("The Winner Is: " + winners.get(0) + "\nScore: " + highScore);
        }

        // otherwise we have a tie:
        System.out.println("We have a tie between:");
        // print all winners using a foreach loop
        // add the required code here

        for(String elements: winners)
        {
            System.out.println(elements);
        }
    }
}
