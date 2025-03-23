
/**
 * 
 * Class Beamer - a beamer in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Beamer" represents one item in the scenery of the game. It is a device that can be charged and fired. When you charge
 * the beamer, it memorizes the current room. When you fire the beamer, it transports you
 * immediately back to the room it was charged in.
 *
 * @author (Amina Hajiyeva 101303729)
 * @version (March 7, 2025)
 */
public class Beamer extends Item
{
    private boolean charge;
    private Room room;
    
    /**
     * Constructor for objects of class Beamer
     */
    public Beamer(String name, String description, double weight)
    {
        super(name, description, weight);
        charge = false;
        room = null;
    }

    /**
     * 
     * Check if the beamer is charged.
     * 
     * @param currentRoom The current room the player is in.
     * @return The charge state of the beamer
     * 
     */
    public boolean checkCharge(Room currentRoom)
    {
        if(charge) // check if beamer is charged
        {
            System.out.println("Beamer is charged");
            room = currentRoom;
            return true;
        }
        else
        {
            System.out.println("Beamer is not charged");
            return false;
        }
    }
    
    /**
     * 
     * Check if the beamer is charged.
     * 
     * @param currentRoom The current room the player is in.
     * 
     */
    public void chargeBeamer(Room currentRoom)
    {
        if(!charge) // check if beamer is charged
        {
            charge = true; // charge beamer
            room = currentRoom;
            System.out.println("Beamer is charged");
        }
        else
        {
            System.out.println("Beamer is already charged");
        }
    }
    
    /**
     * 
     * Fire beamer.
     * 
     * @param currentRoom The current room the player is in.
     * 
     */
    public void fireBeamer(Room currentRoom)
    {
        if(charge) // check if beamer is charged
        {
            charge = false; // discharge/fire beamer
            room = currentRoom;
            System.out.println("Beamer has been fired.");
        }
        else
        {
            System.out.println("Beamer is not charged");
        }
    }
}
