import java.util.*;
/**
 * Class TransporterRoom - a transpoter room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "TransporterRoom" represents one mystery transporter location in the scenery of the game.  It is 
 * connected to other rooms via exits.  This mystery room is determined via random number generation.
 *
 * @author (Amina Hajiyeva 101303729)
 * @version (March 7 2025)
 */
public class TransporterRoom extends Room
{
    private Random rand; // random number to choose room
    private List<Room> rooms; // list of all rooms
    
    /**
     * Constructor for objects of class TransporterRoom
     */
    public TransporterRoom(String description, List<Room> rooms)
    {
        super(description);
        this.rand = new Random();
        this.rooms = rooms;
    }
    
    /**
     *
     * Returns a random room, independent of the direction parameter.
     * @param direction Ignored.
     * @return A randomly selected room.
     */
    public Room getExit(String direction)
    {
        return findRandomRoom();
    }
    
    /**
     *
     * Choose a random room.
     * @return The room we end up in upon leaving this one.
     */
    private Room findRandomRoom()
    {
        int randomRoom =  (int)(Math.random() * rooms.size()); // get random number from 0 to the number of rooms
        return rooms.get(randomRoom); // return random room
    }
}
