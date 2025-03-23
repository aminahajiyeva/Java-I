import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;
/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room. A room may also include an 
 * item(s) which store a description and weight.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 * 
 * @author Lynn Marshall
 * @version October 21, 2012
 * 
 * @author Amina Hajiyeva 101303729
 * @version March 7, 2025
 */

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.

    private ArrayList<Item> items; // list to store items
    private ArrayList<Room> rooms = new ArrayList<Room>();

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * 
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();

        //initialize item and room list
        items = new ArrayList<>();
        rooms.add(this);
    }

    public ArrayList<Room> getRooms()
    {
        return rooms;
    }

    /**
     * Define an exit from this room.
     * 
     * @param direction The direction of the exit
     * @param neighbour The room to which the exit leads
     */
    public void setExit(String direction, Room neighbour) 
    {
        exits.put(direction, neighbour);
    }

    /**
     * Returns a short description of the room, i.e. the one that
     * was defined in the constructor
     * 
     * @return The short description of the room
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a long description of the room with the name of the room, exits, exit locations, items, item descriptions.
     * 
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        String print = "You are " + description + ".\n" + getExitString() + ".\n";

        if(!items.isEmpty()) // if room has items...
        {
            print += " Items: ";
            for(Item elements:items) // for each item in the room...
            {
                print += elements.getDescription() + " "; // get their description
            }
        }
        return  print; // return long description
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * 
     * @return Details of the room's exits
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * 
     * @param direction The exit's direction
     * @return The room in the given direction
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }

    /**
     * Add an item to the room
     * 
     * @param item The item to be added to the room
     */
    public void addItem(Item item)
    {
        if(item!=null) // check if player has a valid item
        {
            items.add(item); // add the item
        }
    }

    /**
     * Remove an item from the room.
     * 
     * @param item The item to be removed from the room.
     */
    public void removeItem(Item item)
    {
        if(item!=null) // check if player has a valid item
        {
            items.remove(item); //remove item from room
        }
    }

    /**
     * Take an item
     * 
     * @param object The name of the item to take
     * @return The item that is taken
     */
    public Item takeItem(String object)
    {
        if(object != null) // check if player has a valid item
        {
            for(Item elements : items) // iterate through each item in room
            {
                if(object.toLowerCase().equals(elements.getName())) // find players desired item in room
                {
                    items.remove(elements); // remove players desired item
                    return elements; // return players desired item
                }
            }
        }
        return null;
    }

    /**
     * Drop an item
     * 
     * @param object The item to drop
     * @return The item that is dropped, or null if no item is found
     */
    public Item dropItem(Item object)
    {
        if(object != null && items.contains(object)) // // check if player has a valid item and if item is in room
        {
            items.add(object); // add item to room - player drops item
            return object;
        }
        return null;
    }
}