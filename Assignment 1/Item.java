/**
 * Class Item - an item in a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * This class defines an item that can be placed in a room in Zuul
 * each item hold a description of iteself as well as its weight.
 *
 * @author Amina Hajiyeva 101303729
 * @version 21/01/2025
 */
public class Item
{
    // instance variables
    private String description;
    private double weight;
        
    /**
     * Constructor for objects of class Item
     * 
     * @param description The description of the item
     * @param weight The weight of the item
     */
    public Item(String description, double weight)
    {
        this.description = description;
        this.weight = weight;
    }

    /**
     * Return a String representation of the item
     * 
     * @return Item description and weight
     */
    public String getDescription()
    {
        return "Description: " + description + "\nWeight: " + weight;
    }
}
