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
 * @version March 7, 2025
 */
public class Item
{
    // instance variables
    private String description;
    private double weight;
    private String name;
        
    /**
     * Constructor for objects of class Item
     * 
     * @param description The description of the item
     * @param weight The weight of the item
     * @param name The name of the ite
     */
    public Item(String name, String description, double weight)
    {
        this.name = name;
        this.description = description;
        this.weight = weight;
    }

    /**
     * Return a String representation of the item
     * 
     * @return Item description and weight and name
     */
    public String getDescription()
    {
        return "Name: " + name + "\nDescription: " + description + "\nWeight: " + weight;
    }
    
    /**
     * Return a String representation of the name of the item
     * 
     * @return Item name
     */
    public String getName()
    {
        return name;
    }

}
