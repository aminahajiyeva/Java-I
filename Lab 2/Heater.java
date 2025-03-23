/**
 * A Heater models a simple space-heater. The operations provided by a Heater
 * object are:
 * 1. Increase and decrease the temperature setting by a set amount.
 * 2. Return the current temperature setting.
 * 3. Change the set amount by which the temperature is increased and lowered.
 * 
 * @author L.S. Marshall, SCE, Carleton University
 * (incomplete implementation for SYSC 2004 Lab 2)
 * @author Amina Hajiyeva
 * @version 1.03 January 14, 2025
 */

public class Heater
{
    /** The maximum and minimum temperature setting that the heater may reach. */
    private final int MAX = 100, MIN = 0;

    /** The temperature setting that the heater should maintain. */
    private int temperature;

    /** The temperature setting for a newly created heater. */
    private static final int INITIAL_TEMPERATURE = 15;

    /** 
     * The amount by which the temperature setting is raised/lowered when
     * warmer() and cooler() are invoked.
     */
    private int increment;

    /** 
     * The default amount by which the temperature setting is 
     * increased when warmer() is invoked and decreased when cooler()
     * is invoked.
     */
    private static final int DEFAULT_INCREMENT = 5;

    private int min, max;

    /**
     * Constructs a new Heater with an initial temperature setting of 15
     * degrees, and which increments and decrements the temperature
     * setting in increments of 5 degrees.
     */
    public Heater()
    {
        temperature = INITIAL_TEMPERATURE;
        increment = DEFAULT_INCREMENT;
        min = MIN;
        max = MAX;
    }

    /**
     * Constructs a new Heater with an initial temperature setting of 15
     * degrees, and which increments and decrements the temperature
     * setting in increments of 5 degrees where the maximum temperature
     * is 100, while the minimum temperature is 0.
     */
    public Heater(int minTemp, int maxTemp)
    {
        temperature = INITIAL_TEMPERATURE;
        increment = DEFAULT_INCREMENT;
        min = minTemp;
        max = maxTemp;
    }

    /**
     * Returns the heater's current temperature setting.
     */    
    public int temperature()
    {
        return temperature;
    }

    /**
     * Increases the heater's temperature by the value stored in the field increment
     */
    public void warmer()
    {
        int temp = temperature + increment;
        if(temp <= max)
        {
            temperature = temp;
        }
    }

    /**
     * Decreases the heater's temperature by the value stored in the field increment
     */    
    public void cooler()
    { 
        int temp = temperature - increment;
        if(temp >= min)
        {
            temperature = temp;
        }
    }

    /**
     * Modifies the new value of the increment to the given value if positive,
     * otherwise increment is not modified.
     */    
    public void setIncrement(int newIncrement)
    { 
        if(newIncrement > 0)
            increment = newIncrement;
        else
            return;
    }
}
