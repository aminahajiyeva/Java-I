package monopoly;
/**
 * The main program for the Monopoly Game.
 *
 * @author Amina Hajiyeva 101303729
 */
public class Main
{
  public static void main(String[] args) 
  {
    // Create a MonopolyGame object called monopoly
    MonopolyGame monopoly = new MonopolyGame();
    monopoly.addPlayer("Susan");
    monopoly.addPlayer("Mo");
    monopoly.addPlayer("Ike");
    monopoly.playGame(5);
  }
}

